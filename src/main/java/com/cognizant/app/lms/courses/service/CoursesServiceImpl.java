package com.cognizant.app.lms.courses.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.app.lms.courses.dto.CourseDTO;
import com.cognizant.app.lms.courses.entity.CourseEntity;
import com.cognizant.app.lms.courses.exception.CoursesServiceException;
import com.cognizant.app.lms.courses.repository.CoursesRepository;

@Service
public class CoursesServiceImpl implements CoursesServiceInt {

	@Autowired
	private CoursesRepository coursesRepository;
	
	private ModelMapper modelMapper;
	
	CoursesServiceImpl(){
		modelMapper= new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Override
	public CourseDTO registerCourse(CourseDTO courseDto) {
		CourseEntity courseEntityToRegister = modelMapper.map(courseDto, CourseEntity.class);
		String cid = UUID.randomUUID().toString();
		courseEntityToRegister.setCourseId(cid);
		CourseEntity registeredCourseEntity = coursesRepository.save(courseEntityToRegister);
		
		CourseDTO registeredCourseDto = modelMapper.map(registeredCourseEntity, CourseDTO.class);
		
		return registeredCourseDto;
	}

	@Override
	public List<CourseDTO> getAllCOurses() {
		List<CourseEntity> allCourseEntities = coursesRepository.findAll();
		
		List<CourseDTO> allCourseDtos = new ArrayList<>();
		
		for(CourseEntity ce : allCourseEntities) {
			allCourseDtos.add(modelMapper.map(ce, CourseDTO.class));
		}
		return allCourseDtos;
	}

	@Override
	public CourseDTO getCourseById(String courseId) {
		CourseEntity courseEntity = coursesRepository.findByCourseId(courseId);
		if(null == courseEntity) {
			throw new CoursesServiceException("Course with given Id doesn't exist");
		}
		CourseDTO courseDto = modelMapper.map(courseEntity, CourseDTO.class);
		return courseDto;
	}

	@Override
	public CourseDTO updateCourseById(CourseDTO courseDto, String courseId) throws CoursesServiceException{
		CourseEntity courseEntityRequiredUpdate = modelMapper.map(courseDto, CourseEntity.class);
		
		CourseEntity retrievedEntity = coursesRepository.findByCourseId(courseId);
		if(null == retrievedEntity) {
			throw new CoursesServiceException("Course with given Id doesn't exist");
		}
		
		retrievedEntity.setCourseName(courseEntityRequiredUpdate.getCourseName());
		retrievedEntity.setCourseDuration(courseEntityRequiredUpdate.getCourseDuration());
		retrievedEntity.setCourseDescription(courseEntityRequiredUpdate.getCourseDescription());
		retrievedEntity.setTechnology(courseEntityRequiredUpdate.getTechnology());
		retrievedEntity.setLaunchURL(courseEntityRequiredUpdate.getLaunchURL());
		
		CourseEntity updatedEntity = coursesRepository.save(retrievedEntity);
		CourseDTO updateCourseDto = modelMapper.map(updatedEntity, CourseDTO.class);
		
		return updateCourseDto;
	}

	@Override
	public String deleteAllCourses() {
		coursesRepository.deleteAll();
		return "Deleted all courses";
	}

	@Override
	public CourseDTO deleteCourseById(String courseId) {
		CourseEntity courseEntityToDelete = coursesRepository.findByCourseId(courseId);
		if(null == courseEntityToDelete) {
			throw new CoursesServiceException("Course with given Id doesn't exist");
		}
		CourseDTO deletedCourseDto = modelMapper.map(courseEntityToDelete, CourseDTO.class);
		coursesRepository.delete(courseEntityToDelete);
		return deletedCourseDto;
	}

}
