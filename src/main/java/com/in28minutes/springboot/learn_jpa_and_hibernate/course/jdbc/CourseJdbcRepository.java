package com.in28minutes.springboot.learn_jpa_and_hibernate.course.jdbc;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository // To tell Spring that this is a repository class and it talks to the database (In this case our course table).
public class CourseJdbcRepository {
    private JdbcTemplate springJdbcTemplate;
    // JdbcTemplate is used to interact with a relational database in Spring applications,
    // providing methods to execute SQL queries, updates, and manage database connections.
    @Autowired
    public CourseJdbcRepository(JdbcTemplate springJdbcTemplate) {
        this.springJdbcTemplate = springJdbcTemplate;
    }
    private static String INSERT_QUERY =
            """
              insert into course (id, name, author)
              values (?, ?, ?);
             
            """;
    private static String DELETE_QUERY =
            """
              delete from course
              where id = ?;
            """;
    private static String SELECT_QUERY =
            """
              select * from course
              where id = ?;
            """;

    public void insert(Course course){ // Method to insert a course into the database.
        springJdbcTemplate.update(INSERT_QUERY,
                course.getId(),
                course.getName(),
                course.getAuthor());
    }
    public void delete(long id){ // Method to delete a course from the database.
        springJdbcTemplate.update(DELETE_QUERY, id);
    }
    // Method to find a course by its ID.
    public Course findById(long id){
        // I am saying i am querying for a specific object.
        return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
        //ResultSet -> Bean => RowMapper (They map each row in the ResultSet to a specific bean)
        // id
    }
}