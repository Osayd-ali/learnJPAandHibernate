package com.in28minutes.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository // To tell Spring that this is a repository class and it talks to the database.
public class CourseJdbcRepository {
    private JdbcTemplate springJdbcTemplate;
    // JdbcTemplate is used to interact with a relational database in Spring applications,
    // providing methods to execute SQL queries, updates, and manage database connections.
    private static String INSERT_QUERY =
            """
              insert into course (id, name, author)
              values (1, 'Introduction to SQL', 'John Doe');
             
            """;
    public void insert(){ // Method to insert a course into the database.
        springJdbcTemplate.update(INSERT_QUERY);
    }
}