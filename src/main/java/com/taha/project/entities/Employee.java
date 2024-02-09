package com.taha.project.entities;


import jakarta.persistence.*;

import java.util.List;
/*
 * @Author: Taha Uzun
 *
 * A class that represents an employee.
 *
 * Employees have unique id, firstName, lastName, email, department, default leaves which gives 15 days for leave
 *
 */
@Entity
@Table(name="employee")
public class Employee {


    /*
    *  Store Unique id for each employees, When we add employee automatically increment the id
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /*
     *  store the firstName of Employee
     */
    @Column(name = "firstName")
    private String firstName;

    /*
     *  store the lastName of Employee
     */
    @Column(name = "lastName")
    private String lastName;

    /*
     *  store the department of Employee
     */
    @Column(name = "department")
    private String department;

    /*
     *  store the email of Employee
     */
    @Column(name ="email")
    private String email;

    /*
     *  store the total default leaves of Employee
     */
    @Column(name = "default_leave_days")
    private int defaultLeaveDays = 15;


    /* a method to return the current id of the employee
     * @return Long representing the current employee id
     */
    public Long getId() {
        return id;
    }

    /* a method to change the current id of the employee
     * @param Long representing the current employee id
     */
    public void setId(Long id) {
        this.id = id;
    }
    /* Retrieve the firstName of the employee
     * @return String employee firstName
     */
    public String getFirstName() {
        return firstName;
    }
    /* Change the name of the employee
     * @param String employee firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    /*
     * Retrieve the last name of the Employee.
     * @return String representing the employee's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /*
     * Set the last name of the Employee.
     * @param String representing the employee's last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*
     * Retrieve the department of the Employee.
     * @return String representing the employee's department.
     */
    public String getDepartment() {
        return department;
    }

    /*
     * Set the department of the Employee.
     * @param String representing the employee's department.
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /*
     * Retrieve the email of the Employee.
     * @return String representing the employee's email.
     */
    public String getEmail() {
        return email;
    }

    /*
     * Set the email of the Employee.
     * @param String representing the employee's email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /*
     * Retrieve the total default leaves of the Employee.
     * @return int representing the employee's default leave days.
     */
    public int getDefaultLeaveDays() {
        return defaultLeaveDays;
    }

    /*
     * Set the total default leaves of the Employee.
     * @param int representing the employee's default leave days.
     */
    public void setDefaultLeaveDays(int defaultLeaveDays) {
        this.defaultLeaveDays = defaultLeaveDays;
    }
}
