package com.example.springboot.cruddemo.dao;

import java.util.List;

import com.example.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
    
}
