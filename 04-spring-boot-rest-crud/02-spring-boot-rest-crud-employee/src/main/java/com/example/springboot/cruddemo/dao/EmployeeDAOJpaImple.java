package com.example.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.springboot.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImple implements EmployeeDAO {


    private EntityManager entityManager;

    public EmployeeDAOJpaImple(EntityManager entityManager){
        this.entityManager = entityManager;
    }



    @Override
    public List<Employee> findAll() {
        
        TypedQuery<Employee> theQuery = entityManager.createQuery("From Employee", Employee.class);

        List<Employee> employees = theQuery.getResultList();

        return employees;
    }



    @Override
    public Employee findById(int theId) {
        
        Employee employee = entityManager.find(Employee.class,theId);
        return employee;
    }



    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge(theEmployee);
        return dbEmployee;

    }



    @Override
    public void deleteById(int theId) {
        
        Employee employee = entityManager.find(Employee.class, theId);
        entityManager.remove(employee);
    }
    
}
