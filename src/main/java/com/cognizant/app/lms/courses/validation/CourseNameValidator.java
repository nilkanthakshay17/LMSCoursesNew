package com.cognizant.app.lms.courses.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.cognizant.app.lms.courses.annotation.CourseName;

@Component
public class CourseNameValidator implements ConstraintValidator<CourseName, String> {

	@Override
	public boolean isValid(String courseNameValue, ConstraintValidatorContext context) {
		if (null != courseNameValue && courseNameValue.length() >= 20)
			return true;
		else
			return false;
	}

}
