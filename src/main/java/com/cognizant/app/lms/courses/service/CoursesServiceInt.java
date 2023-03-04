package com.cognizant.app.lms.courses.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.app.lms.courses.dto.CourseDTO;

@Service
public interface CoursesServiceInt {
	public CourseDTO registerCourse(CourseDTO courseDto);
	public List<CourseDTO> getAllCOurses();
	public CourseDTO getCourseById(String courseId);
	public CourseDTO updateCourseById(CourseDTO courseDto, String courseId);
	public String deleteAllCourses();
	public CourseDTO deleteCourseById(String courseId);
}
