package com.example.demo.database;

import com.example.demo.modal.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // No need to define addEmployee manually; JPA handles basic CRUD
}
