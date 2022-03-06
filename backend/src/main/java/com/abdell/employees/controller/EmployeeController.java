package com.abdell.employees.controller;

import java.util.List;

import com.abdell.employees.entity.Employee;
import com.abdell.employees.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
@CrossOrigin



public class EmployeeController {

    @Autowired
    EmployeeService employeeService;



    @GetMapping("/")
    public ResponseEntity<List<Employee>> index(){
        List<Employee> list = employeeService.index();
        return new ResponseEntity(list, HttpStatus.OK);
    }





    
}
