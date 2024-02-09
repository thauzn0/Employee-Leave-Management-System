package com.taha.project.entities;

import com.taha.project.entities.Employee;
import jakarta.persistence.*;
import java.time.LocalDate;

/*
 * @Author: Taha Uzun
 * A class that represents a leave taken by an employee.
 *
 * Leaves have unique id, associated employee, start date, end date, and reason.
 */
@Entity
@Table(name="leaves")
public class Leaves {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * The employee associated with this leave.
     */
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    /*
     * The start date of the leave.
     */
    @Column(name = "start_date")
    private LocalDate startDate;

    /*
     * The end date of the leave.
     */
    @Column(name = "end_date")
    private LocalDate endDate;

    /*
     * The reason for taking the leave.
     */
    @Column(name = "reason")
    private String reason;

    /*
     * Default constructor for Leaves class.
     */
    public Leaves() {
    }

    /*
     * Parameterized constructor for Leaves class.
     * @param id Long representing the unique id of the leave.
     * @param employee Employee representing the employee associated with the leave.
     * @param startDate LocalDate representing the start date of the leave.
     * @param endDate LocalDate representing the end date of the leave.
     * @param reason String representing the reason for taking the leave.
     */
    public Leaves(Long id, Employee employee, LocalDate startDate, LocalDate endDate, String reason) {
        this.id = id;
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
    }

    /*
     * Retrieve the unique id of the leave.
     * @return Long representing the unique id of the leave.
     */
    public Long getId() {
        return id;
    }

    /*
     * Set the unique id of the leave.
     * @param id Long representing the unique id of the leave.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /*
     * Retrieve the employee associated with the leave.
     * @return Employee representing the employee associated with the leave.
     */
    public Employee getEmployee() {
        return employee;
    }

    /*
     * Set the employee associated with the leave.
     * @param employee Employee representing the employee associated with the leave.
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /*
     * Retrieve the start date of the leave.
     * @return LocalDate representing the start date of the leave.
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /*
     * Set the start date of the leave.
     * @param startDate LocalDate representing the start date of the leave.
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /*
     * Retrieve the end date of the leave.
     * @return LocalDate representing the end date of the leave.
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /*
     * Set the end date of the leave.
     * @param endDate LocalDate representing the end date of the leave.
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /*
     * Retrieve the reason for taking the leave.
     * @return String representing the reason for taking the leave.
     */
    public String getReason() {
        return reason;
    }

    /*
     * Set the reason for taking the leave.
     * @param reason String representing the reason for taking the leave.
     */
    public void setReason(String reason) {
        this.reason = reason;
    }
}
