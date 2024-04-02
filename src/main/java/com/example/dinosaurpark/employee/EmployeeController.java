package com.example.dinosaurpark.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import lombok.RequiredArgsConstructor;

//getRandomHealthRecord를 사용하기 위한 임포트
import com.example.dinosaurpark.healthrecord.HealthRecord;
import com.example.dinosaurpark.healthrecord.HealthRecordService;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    
    private final EmployeeService employeeService;

    @Autowired
    private HealthRecordService healthRecordService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok().body(employees);
    }

    @GetMapping(value = "/{empId}", produces = "application/json")
    public ResponseEntity<EmployeeWithHealthRecord> getEmployeeById(@PathVariable("empId") Integer id) {
        Employee employee = employeeService.getEmployeeById(id);

        List<HealthRecord> healthRecords = healthRecordService.getRandomHealthRecord(3);
        
        EmployeeWithHealthRecord employeeWithHealthRecord = new EmployeeWithHealthRecord(employee, healthRecords);

        return ResponseEntity.ok().body(employeeWithHealthRecord);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @PutMapping("/{empId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("empId") Integer id, @RequestBody Employee updatedEmployee) {
        Employee employee = employeeService.updateEmployee(id, updatedEmployee);
        return ResponseEntity.ok().body(employee);
    }

    @DeleteMapping("/{empId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("empId") Integer id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
