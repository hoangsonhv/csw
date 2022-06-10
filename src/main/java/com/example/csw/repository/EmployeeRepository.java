package com.example.csw.repository;

import com.example.csw.entity.Employee;

import java.util.List;

public interface EmployeeRepository {

    Employee save(Employee obj);

    Employee update(Employee obj, int id);

    boolean delete(int id);

    List<Employee> findAll();

    Employee findById(int id);
}
