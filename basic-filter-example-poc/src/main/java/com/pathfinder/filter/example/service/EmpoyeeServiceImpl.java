package com.pathfinder.filter.example.service;

import com.pathfinder.filter.example.dto.Employee;
import com.pathfinder.filter.example.repository.EmployeeDB;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
public class EmpoyeeServiceImpl{

    public List<Employee> getAllEmp() throws IOException{
        return  EmployeeDB.getAllEmployee();
    }

    public Employee saveEmployee(Employee employee) {
        return  employee;
    }

    public Employee getEmployeeById(Integer employeeId) throws IOException{
        return EmployeeDB.getAllEmployee().stream().filter(employee ->
         Integer.parseInt(employee.getEmployeeId()) == employeeId
        ).findFirst().orElseThrow(() ->  new RuntimeException("Employee Not found"));
    }

}

