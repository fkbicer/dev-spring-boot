package com.example.springboot.cruddemo.dao;

import java.util.List;

import com.example.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {

    List<Employee> findAll();
    
}
