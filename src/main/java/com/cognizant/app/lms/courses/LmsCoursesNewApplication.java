package com.cognizant.app.lms.courses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class LmsCoursesNewApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmsCoursesNewApplication.class, args);
		System.out.println("LMS Courses Service Started Git Check");
	}

}
