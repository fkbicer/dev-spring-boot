package com.example.springboot.cruddemo.service;

import java.util.List;

import com.example.springboot.cruddemo.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();
    
}
