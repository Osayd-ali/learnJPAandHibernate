package com.in28minutes.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
    // CommandLineRunner is a functional interface in Spring Boot that indicates a bean should run when it is contained within a SpringApplication.
    // It is typically used to execute some code after the application has started and the Spring context
    // has been initialized. This is often useful for tasks such as initializing data, performing setup operations, or running any custom logic at startup.
    // The run method is called with command-line arguments passed to the application.
    // Now we are autowiring the CourseJdbcRepository to use it in the run method.
    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert();
    }
}