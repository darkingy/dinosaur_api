package com.example.dinosaurpark.employee;

import org.springframework.stereotype.Service;
import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id)
                                    .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Integer id, Employee updatedEmployee) {
        Employee employee = getEmployeeById(id);
        
        employee.setEmpAddress(updatedEmployee.getEmpAddress());
        employee.setEmpBirth(updatedEmployee.getEmpBirth());
        employee.setEmpDepart(updatedEmployee.getEmpDepart());
        employee.setEmpEmail(updatedEmployee.getEmpEmail());
        employee.setEmpName(updatedEmployee.getEmpName());
        employee.setEmpPhone(updatedEmployee.getEmpPhone());
        employee.setEmpPosition(updatedEmployee.getEmpPosition());
        employee.setEmpWorkYear(updatedEmployee.getEmpWorkYear());

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}
