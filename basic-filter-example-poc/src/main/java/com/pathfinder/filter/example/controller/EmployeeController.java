package com.pathfinder.filter.example.controller;

import com.pathfinder.filter.example.dto.Employee;
import com.pathfinder.filter.example.service.EmpoyeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/employeeInfo")
public class EmployeeController{

    @Autowired
    EmpoyeeServiceImpl empoyeeService;

    @GetMapping(value = "/getemployees" , produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> fetchAllEmployee( ) throws IOException{
        final List<Employee> employeeDtos = empoyeeService.getAllEmp();
        return ResponseEntity.status(HttpStatus.OK).body(employeeDtos);
    }

    @PostMapping(value = "/saveemployee" , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) throws IOException{
        final Employee empResponse = empoyeeService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(empResponse);
    }

    @GetMapping(value = "/getemployeebyid/{employeeId}" , produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> fetchAllEmployee(@PathVariable("employeeId") String employeeId ) throws IOException{
        final Employee employeeById = empoyeeService.getEmployeeById(Integer.parseInt(employeeId));
        return ResponseEntity.status(HttpStatus.OK).body(employeeById);
    }
}
