package com.cognizant.app.lms.courses.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.cognizant.app.lms.courses.annotation.CourseDuration;

@Component
public class CourseDurationValidator implements ConstraintValidator<CourseDuration, String> {

	@Override
	public boolean isValid(String nameDurationValue, ConstraintValidatorContext context) {
		if (null == nameDurationValue)
			return false;
		else {
			Pattern durationPattern = Pattern.compile("([0-9]+)");
			Matcher durationMatcher = durationPattern.matcher(nameDurationValue.toString());
			return durationMatcher.matches();
		}

	}

}
