package com.example.dinosaurpark.employee;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String empName;

    @Column
    private String empPosition;

    @Column
    private String empDepart;

    @Column
    private String empEmail;

    @Column
    private String empPhone;

    @Column
    private String empAddress;

    @Column
    private LocalDate empBirth;

    @Column
    private Integer empWorkYear;
}
