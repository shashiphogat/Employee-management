package com.example.demo.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employee") // optional, sets table name
public class Employee {

    @Id
    private int id;
    private String name;
    private double salary;
}
