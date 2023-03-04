package com.cognizant.app.lms.courses.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lms_courses")
public class CourseEntity {

	@Id
	@GeneratedValue
	private int crsid;
	
	@Column(name = "course_id")
	private String courseId;
	
	@Column(name = "name")
	private String courseName;
	
	@Column(name = "duration")
	private String courseDuration;
	
	@Column(name = "description")
	private String courseDescription;
	
	@Column
	private String technology;
	
	@Column(name = "launchurl")
	private String launchURL;

	public int getCrsid() {
		return crsid;
	}

	public void setCrsid(int crsid) {
		this.crsid = crsid;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getLaunchURL() {
		return launchURL;
	}

	public void setLaunchURL(String launchURL) {
		this.launchURL = launchURL;
	}
	
}
