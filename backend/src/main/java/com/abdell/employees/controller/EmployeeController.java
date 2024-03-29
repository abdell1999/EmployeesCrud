package com.abdell.employees.controller;

import java.util.List;

import com.abdell.employees.dto.EmployeeDto;
import com.abdell.employees.dto.Message;
import com.abdell.employees.entity.Employee;
import com.abdell.employees.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/{id}")
    public ResponseEntity<Employee> get(@PathVariable("id") int id){

        Employee Employee = employeeService.get(id).get();
        return new ResponseEntity(Employee, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        employeeService.delete(id);
        return new ResponseEntity(new Message("The employee has been deleted successfully"), HttpStatus.OK);
    }


    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody EmployeeDto employeeDto){
        Employee employee = new Employee(employeeDto.getName(), employeeDto.getEmail(), employeeDto.getPhone());
        employeeService.store(employee);
        return new ResponseEntity(new Message("The employee has been created successfully"), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody EmployeeDto employeeDto){
        
        Employee employee = employeeService.get(id).get();
        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhone(employeeDto.getPhone());
        employeeService.store(employee);
        return new ResponseEntity(new Message("The employee has been updated successfully"), HttpStatus.OK);
    }


    
}
