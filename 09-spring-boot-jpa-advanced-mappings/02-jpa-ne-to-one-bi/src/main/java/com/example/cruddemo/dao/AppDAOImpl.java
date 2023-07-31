package com.example.cruddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;

@Repository
public class AppDAOImpl implements AppDAO {

    // define field for entity manager

    private EntityManager entityManager;

    // inject entity manager using contr inj.

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void save(Instructor theInsturctor) {
        
        entityManager.persist(theInsturctor);

    }


    @Override
    public Instructor findInstructorById(int theId) {
            return entityManager.find(Instructor.class, theId);
    }


    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        Instructor tempInstructor = entityManager.find(Instructor.class,theId);
        entityManager.remove(tempInstructor);
    }


    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
     return entityManager.find(InstructorDetail.class, theId);
    }


    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class,theId);

        entityManager.remove(tempInstructorDetail);
    }
    
}
