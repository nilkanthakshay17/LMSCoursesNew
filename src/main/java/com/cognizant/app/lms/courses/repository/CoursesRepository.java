package com.cognizant.app.lms.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cognizant.app.lms.courses.entity.CourseEntity;

@Repository
public interface CoursesRepository extends JpaRepository<CourseEntity	, Integer>{
	public CourseEntity findByCourseId(String courseId);
}
