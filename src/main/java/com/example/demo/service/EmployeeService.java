package com.example.demo.service;

import com.example.demo.modal.Employee;
import com.example.demo.database.EmployeeRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String addEmployee(Employee employee) {
        try {
            employeeRepository.save(employee);  // JPA handles INSERT automatically
            return "Employee added successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
    public String deleteEmployee(Integer id)
    {
        try {
            if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
            return "Employee deleted successfully";
            }
            else 
            return "Employee not exists!!!";
        } catch (Exception e) {
           e.printStackTrace();
           return "Error: " + e.getMessage();
        }
    }
    public List<Employee> viewAll()
    {
        try {
            return employeeRepository.findAll();
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }
    public String updateEmployee(Integer id,String name,Double salary)
    {
        Optional<Employee> existing=employeeRepository.findById(id);
        if(existing.isPresent())
        {
            Employee employee=existing.get();
            employee.setName(name);
            employee.setSalary(salary);
            employeeRepository.save(employee);
            return "Employee data updated successfully....";
        }
        else
        return "Employee does not exists!!!!!";
    }
}
