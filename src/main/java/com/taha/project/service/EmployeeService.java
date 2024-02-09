package com.taha.project.service;

import com.taha.project.entities.Employee;
import com.taha.project.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    EmployeeRepository employeeRepository;

    //constructor injection
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee addEmployee(Employee employee) {
      return  employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found with id: " + id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDefaultLeaveDays(employee.getDefaultLeaveDays());
        return employeeRepository.save(existingEmployee);
    }
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
