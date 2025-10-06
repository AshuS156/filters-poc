package com.pathfinder.filter.example.repository;

import com.pathfinder.filter.example.dto.Employee;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDB{

    public static List<Employee> getAllEmployee() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        List<Employee> employees = new ArrayList<>();
        try {
            employees = objectMapper.readValue(new File("src/main/resources/employees.json"), new TypeReference<List<Employee>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return   employees;
    }
}
