package com.in28minutes.springboot.learn_jpa_and_hibernate.course.jpa;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // To tell Spring that this is a repository class and it talks to the database.
@Transactional // To manage transactions automatically. (Begin, Commit, Rollback)
// Transactional annotation is used to manage transactions in a declarative way.
public class CourseJpaRepository {
    //We will use EntityManager to manage our entity which is Course.
    //EntityManager is the primary JPA interface used to interact with the persistence context.
    //It provides methods for performing CRUD (Create, Read, Update, Delete) operations on
    // entities, managing transactions, and executing queries.
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course){
        entityManager.merge(course); // merge is used to insert or update an entity.
        // merge will automatically map each attribute of the Course class to the corresponding column in the course table.
        // If the entity already exists in the database (based on its primary key), it will
        // be updated; otherwise, a new entity will be inserted.
    }

    public Course findById(long id){
        return entityManager.find(Course.class, id);
        // find method is used to retrieve an entity by its primary key.
    }

    public void deleteById(long id){
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
        // remove method is used to delete an entity from the database.
    }
}