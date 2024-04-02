package com.example.dinosaurpark.employee;

import com.example.dinosaurpark.healthrecord.HealthRecord;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeWithHealthRecord {
    private Employee employee;
    private List<HealthRecord> healthRecords;

    public EmployeeWithHealthRecord(Employee employee, List<HealthRecord> healthRecords) {
        this.employee = employee;
        this.healthRecords = healthRecords;
    }
}
