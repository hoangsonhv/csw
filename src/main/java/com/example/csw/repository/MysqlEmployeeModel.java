package com.example.csw.repository;


import com.example.csw.entity.Employee;
import com.example.csw.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MysqlEmployeeModel implements EmployeeRepository{
    @Override
    public Employee save(Employee obj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into employees (name,salary) values (?,?)";
            PreparedStatement preparedStatement =  connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setDouble(2, obj.getSalary());
            preparedStatement.execute();
            System.out.println("Create success.");
            return obj;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee update(Employee updateObj, int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update employees " +
                    "set name = ?, price = ? where id = ?";
            PreparedStatement preparedStatement =  connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, updateObj.getName());
            preparedStatement.setDouble(2, updateObj.getSalary());
            preparedStatement.setInt(3, id);
            preparedStatement.execute();
            System.out.println("Update success.");
            return updateObj;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "delete from employees " +
                    "where id = ?";
            PreparedStatement preparedStatement =  connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            System.out.println("Delete success.");
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from employees";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Double salary = resultSet.getDouble("salary");
                Employee obj = new Employee();
                obj.setId(id);
                obj.setName(name);
                obj.setSalary(salary);
                employees.add(obj);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee obj = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from employees where id = ?";
            PreparedStatement preparedStatement =  connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                obj = new Employee();
                obj.setId(id);
                obj.setName(name);
                obj.setSalary(salary);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return obj;
    }
}
