package com.in28minutes.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository // To tell Spring that this is a repository class and it talks to the database.
public class CourseJdbcRepository {
    private JdbcTemplate springJdbcTemplate;
}