package com.example.demo.controller;

import com.example.demo.modal.Employee;
import com.example.demo.service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller//@rest controller act as controller + responsebody
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add-employee")
    @ResponseBody
    public String addEmployee(
            @RequestParam("eid") Integer id,
            @RequestParam("name") String name,
            @RequestParam("salary") Double salary) {
        try {
            Employee employee = new Employee();
            employee.setId(id);
            employee.setName(name);
            employee.setSalary(salary);

            return employeeService.addEmployee(employee);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
    @DeleteMapping("/delete-employee/{eid}")
    @ResponseBody
    public String deleteEmployee(@PathVariable("eid") Integer id) {
        try {
            return employeeService.deleteEmployee(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
    @GetMapping("/view-employee")
    @ResponseBody
    public List<Employee> viewEmployee()
    {
        return employeeService.viewAll();
    }
    @PostMapping("/update-employee")
    @ResponseBody
    public String updateEmployee(@RequestParam("eid") Integer id,
    @RequestParam("name") String name,
    @RequestParam("salary") Double salary)
    {
        return employeeService.updateEmployee(id,name,salary);
    }
}
