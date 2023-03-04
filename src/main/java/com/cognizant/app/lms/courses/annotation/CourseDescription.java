package com.cognizant.app.lms.courses.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.cognizant.app.lms.courses.validation.CourseDescriptionValidator;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Constraint(validatedBy = CourseDescriptionValidator.class)
public @interface CourseDescription {
	
	public String message() default "Course Description should be minimum 100 characters";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
