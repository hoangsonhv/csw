package com.example.csw.resource;

import com.example.csw.entity.Employee;
import com.example.csw.repository.EmployeeRepository;
import com.example.csw.repository.MysqlEmployeeModel;

import javax.ws.rs.*;
import java.util.List;

@Path("/employees")
@Produces("application/json")
@Consumes("application/json")
public class EmployeeResource {

    EmployeeRepository employeeRepository;

    public EmployeeResource(){
        employeeRepository = new MysqlEmployeeModel();
    }

    @GET
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    @GET
    @Path("{id}")
    public Employee findById(@PathParam("id") int id){
        return employeeRepository.findById(id);
    }

    @POST
    public Employee save(Employee obj){
        return employeeRepository.save(obj);
    }

    @PUT
    @Path("{id}")
    public Employee update(@PathParam("id") int id, Employee updateProduct){
        return employeeRepository.update(updateProduct, id);
    }

    @DELETE
    @Path("{id}")
    public boolean delete(@PathParam("id") int id){
        return employeeRepository.delete(id);
    }
}
