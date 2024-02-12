package com.taha.project.service;

import com.taha.project.entities.Employee;
import com.taha.project.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    EmployeeRepository employeeRepository;

    /*
     * Constructor injector for EmployeeService.
     * @param employeeRepository An instance of EmployeeRepository to perform CRUD operations on Employee entities.
     *
     */
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /*
     * Retrieve all employees.
     * @return List<Employee> representing all employees.
     */
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    /*
     * Retrieve an employee by id.
     * @param id Long representing the id of the employee to retrieve.
     * @return employee representing the employee with the given id, or null if not found.
     */
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    /*
     * Add a new employee.
     * @param employees employee object representing the employee to add.
     * @return employee representing the added employee.
     */
    public Employee addEmployee(Employee employee) {
      return  employeeRepository.save(employee);
    }

    /*
     * Update an existing employee.
     * @param id Long representing the id of the employee to update.
     * @param employees employee object representing the updated information of the employee.
     * @return employee representing the updated employee.
     * @throws IllegalArgumentException if the leave with the given id is not found.
     */
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

    /*
     * Delete an employee by id.
     * @param id Long representing the id of the employee to delete.
     */
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
