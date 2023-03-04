package com.cognizant.app.lms.courses.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.app.lms.courses.dto.CourseDTO;
import com.cognizant.app.lms.courses.model.CourseRequestModel;
import com.cognizant.app.lms.courses.model.CourseResponseModel;
import com.cognizant.app.lms.courses.service.CoursesServiceInt;


@RestController
@RequestMapping("/api/v1.0/course")
public class CoursesController {
	
	@Autowired
	private CoursesServiceInt coursesServiceInt;
	
	private ModelMapper modelMapper;
	
	CoursesController(){
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@GetMapping("/status")
	public String getStatus() {
		return "Working....";
	}

	@PostMapping
	public ResponseEntity<CourseResponseModel> registerCourse(@RequestBody @Validated CourseRequestModel courseRequestModel){
		CourseDTO courseDtoToRegister = modelMapper.map(courseRequestModel, CourseDTO.class);
		
		CourseDTO registerdCourseDto = coursesServiceInt.registerCourse(courseDtoToRegister);
		
		CourseResponseModel registeredCourseResponse = modelMapper.map(registerdCourseDto, CourseResponseModel.class);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(registeredCourseResponse);
	}
	
	@GetMapping
	public ResponseEntity<List<CourseResponseModel>> getAllCourses(){
		List<CourseDTO> allCourseDtos = coursesServiceInt.getAllCOurses();
		
		List<CourseResponseModel> allCourseResponse = new ArrayList<>();
		
		for(CourseDTO cd :allCourseDtos) {
			allCourseResponse.add(modelMapper.map(cd, CourseResponseModel.class));
		}
		return ResponseEntity.status(HttpStatus.OK).body(allCourseResponse);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CourseResponseModel> getCourseById(@PathVariable(name = "id")String id){
		CourseDTO courseDto = coursesServiceInt.getCourseById(id);
		CourseResponseModel courseResponse = modelMapper.map(courseDto, CourseResponseModel.class);
		return ResponseEntity.status(HttpStatus.OK).body(courseResponse);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<CourseResponseModel> updateCourseById(@RequestBody CourseRequestModel updateRequest, @PathVariable(name = "id")String id){
		CourseDTO courseDtoToUpdate = modelMapper.map(updateRequest, CourseDTO.class);
		CourseDTO updatedCourseDto = coursesServiceInt.updateCourseById(courseDtoToUpdate,id);
		CourseResponseModel updatedCourseResponse = modelMapper.map(updatedCourseDto, CourseResponseModel.class);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedCourseResponse);
	}
	
	@DeleteMapping
	public String deleteAllCourses() {
		return coursesServiceInt.deleteAllCourses();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String,CourseResponseModel>> deleteCourseById(@PathVariable(name = "id")String id){
		CourseDTO deletedCourseDto = coursesServiceInt.deleteCourseById(id);
		CourseResponseModel deletedCourseResponse = modelMapper.map(deletedCourseDto, CourseResponseModel.class);
		Map<String,CourseResponseModel> deleteResMap = new HashMap<>();
		deleteResMap.put("Deleted Course-", deletedCourseResponse);
		return ResponseEntity.status(HttpStatus.OK).body(deleteResMap);
	}
}
