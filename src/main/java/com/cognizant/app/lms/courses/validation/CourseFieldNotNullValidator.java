package com.cognizant.app.lms.courses.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.cognizant.app.lms.courses.annotation.CourseFieldNotNull;

@Component
public class CourseFieldNotNullValidator implements ConstraintValidator<CourseFieldNotNull, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (null == value || "" == value)
			return false;
		else
			return true;
	}

	
}
