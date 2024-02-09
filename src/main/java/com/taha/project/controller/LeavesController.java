package com.taha.project.controller;

import com.taha.project.entities.Employee;
import com.taha.project.entities.Leaves;
import com.taha.project.service.EmployeeService;
import com.taha.project.service.LeavesService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

/*
 * Controller class for handling HTTP requests related to Leaves entities.
 * Defines endpoints for CRUD operations on Leaves entities.
 *
 */
@RestController
@RequestMapping("/leaves")
public class LeavesController {
    private final LeavesService leavesService;
    private final EmployeeService employeeService;

    /*
     * Constructor injector for LeavesController.
     * @param leavesService An instance of LeavesService to handle business logic related to Leaves entities.
     * @param employeeService An instance of EmployeeService to handle business logic related to Employee entities.
     */
    public LeavesController(LeavesService leavesService, EmployeeService employeeService) {
        this.leavesService = leavesService;
        this.employeeService = employeeService;
    }

    /*
     * Endpoint to retrieve all leaves.
     * @return List<Leaves> representing all leaves.
     */
    @GetMapping
    public List<Leaves> getAllLeaves() {
        return leavesService.getAllLeaves();
    }

    /*
     * Endpoint to retrieve a leave by id.
     * @param id Long representing the id of the leave to retrieve.
     * @return Leaves representing the leave with the given id.
     */
    @GetMapping("/{id}")
    public Leaves getLeavesById(@PathVariable Long id) {
        return leavesService.getLeavesById(id);
    }

    /*
     * Endpoint to retrieve all leaves for a specific employee.
     * @param employeeId Long representing the id of the employee.
     * @return List<Leaves> representing all leaves associated with the given employee.
     */
    @GetMapping("/employee/{employeeId}/leaves")
    public List<Leaves> getLeavesByEmployeeId(@PathVariable Long employeeId) {
        return leavesService.getLeavesByEmployeeId(employeeId);
    }

    /*
     * Endpoint to add a new leave.
     * @param leaves Leaves object representing the leave to add.
     * @return Leaves representing the added leave.
     */
    @PostMapping
    public Leaves addLeaves(@RequestBody Leaves leaves) {
        // Add the leave entry
        Leaves addedLeaves = leavesService.addLeaves(leaves);

        // Calculate the difference between startDate and endDate
        long difference = ChronoUnit.DAYS.between(leaves.getStartDate(), leaves.getEndDate());

        // Subtract it from defaultLeaveDays
        int remainingLeaveDays = leaves.getEmployee().getDefaultLeaveDays() - (int) difference;

        // Set the calculated remaining leave days to the Employee object
        leaves.getEmployee().setDefaultLeaveDays(remainingLeaveDays);

        // Save the updated Employee object
        employeeService.updateEmployee(leaves.getEmployee().getId(), leaves.getEmployee());

        // Return the updated Leaves object
        return addedLeaves;
    }

    /*
     * Endpoint to update an existing leave.
     * @param id Long representing the id of the leave to update.
     * @param leaves Leaves object representing the updated information of the leave.
     * @return Leaves representing the updated leave.
     */
    @PutMapping("/{id}")
    public Leaves updateLeaves(@PathVariable Long id, @RequestBody Leaves leaves) {
        return leavesService.updateLeaves(id, leaves);
    }

    /*
     * Endpoint to delete a leave by id.
     * @param id Long representing the id of the leave to delete.
     */
    @DeleteMapping("/{id}")
    public void deleteLeaves(@PathVariable Long id) {
        // Get the leaves to be deleted
        Leaves deletedLeaves = leavesService.getLeavesById(id);
        int deletedLeaveDays = calculateLeaveDays(deletedLeaves.getStartDate(), deletedLeaves.getEndDate());

        // Delete the leave
        leavesService.deleteLeaves(id);

        // Add the deleted leave days back to the total leaves
        Employee employee = deletedLeaves.getEmployee();
        int defaultLeaveDays = employee.getDefaultLeaveDays();
        employee.setDefaultLeaveDays(defaultLeaveDays + deletedLeaveDays);
        employeeService.updateEmployee(employee.getId(), employee);
    }

    /*
     * method to calculate the number of leave days between two dates.
     * @param startDate LocalDate representing the start date of the leave.
     * @param endDate LocalDate representing the end date of the leave.
     * @return int representing the number of leave days.
     */
    private int calculateLeaveDays(LocalDate startDate, LocalDate endDate) {
        return (int) ChronoUnit.DAYS.between(startDate, endDate); // Başlangıç ve bitiş tarihlerini
    }

}
