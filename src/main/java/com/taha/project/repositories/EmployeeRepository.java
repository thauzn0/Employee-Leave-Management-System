package com.taha.project.repositories;

import com.taha.project.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * Repository interface for Employee entities.
 * Extends JpaRepository to provide CRUD operations for Employee entities.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
