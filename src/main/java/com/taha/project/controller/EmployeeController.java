package com.taha.project.controller;

import com.taha.project.entities.Employee;
import com.taha.project.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
 * Controller class for handling HTTP requests related to Employee entities.
 * Defines endpoints for CRUD operations on Employee entities.
 *
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;


    /*
     * Constructor for EmployeeController.
     * @param employeeService An instance of EmployeeService to handle business logic related to Employee entities.
     *
     */
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /*
     * Endpoint to retrieve all employees.
     * @return List<Employee> representing all employees.
     */
    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    /*
     * Endpoint to retrieve an employee by id.
     * @param id Long representing the id of the employee to retrieve.
     * @return Optional<Employee> representing the employee with the given id if found, otherwise empty.
     */
    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    /*
     * Endpoint to add a new employee.
     * @param employee Employee object representing the employee to add.
     * @return Employee representing the added employee.
     */
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    /*
     * Endpoint to update an existing employee.
     * @param id Long representing the id of the employee to update.
     * @param employee Employee object representing the updated information of the employee.
     * @return Employee representing the updated employee.
     */
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    /*
     * Endpoint to delete an employee by id.
     * @param id Long representing the id of the employee to delete.
     */
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

}
