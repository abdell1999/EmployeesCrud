package com.abdell.employees.service;

import com.abdell.employees.entity.Employee;
import com.abdell.employees.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    EmployeeRepository EmployeeRepository;

    public List<Employee> index(){
        return EmployeeRepository.findAll();
    }

    public Optional<Employee> get(int id){
        return EmployeeRepository.findById(id);
    }

    public void  store(Employee Employee){
        EmployeeRepository.save(Employee);
    }

    public void delete(int id){
        EmployeeRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return EmployeeRepository.existsById(id);
    }
}
