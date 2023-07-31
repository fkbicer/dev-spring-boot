package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInsturctor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);
    
}
