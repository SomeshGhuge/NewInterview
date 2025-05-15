package com.example.new_interview.new_interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication is a convenience annotation that adds all of the following:
 * 1. @Configuration: Tags the class as a source of bean definitions for the application context
 * 2. @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings
 * 3. @ComponentScan: Tells Spring to look for other components, configurations, and services in the current package
 * 
 * Why use @SpringBootApplication?
 * - Reduces boilerplate code by combining multiple annotations
 * - Enables auto-configuration of Spring application context
 * - Automatically scans for components in the current package and sub-packages
 * 
 * Alternative approaches:
 * - Could use individual annotations (@Configuration, @EnableAutoConfiguration, @ComponentScan)
 * - Could use @SpringBootConfiguration for more explicit configuration
 */
@SpringBootApplication
public class NewInterviewApplication {

	/**
	 * Main method that bootstraps the Spring Boot application
	 * 
	 * Why use SpringApplication.run()?
	 * - Creates and configures the Spring application context
	 * - Starts the embedded web server (if present)
	 * - Performs component scanning and auto-configuration
	 * 
	 * Parameters:
	 * - NewInterviewApplication.class: The primary source class
	 * - args: Command line arguments passed to the application
	 * 
	 * What happens if not used?
	 * - Application won't start
	 * - No Spring context will be created
	 * - No auto-configuration will be performed
	 */
	public static void main(String[] args) {
		SpringApplication.run(NewInterviewApplication.class, args);
	}

}
