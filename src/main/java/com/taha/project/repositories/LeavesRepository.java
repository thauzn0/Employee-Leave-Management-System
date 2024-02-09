package com.taha.project.repositories;

import com.taha.project.entities.Leaves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Repository interface for Leaves entities.
 * Extends JpaRepository to provide CRUD operations for Leaves entities.
 */
@Repository
public interface LeavesRepository extends JpaRepository<Leaves, Long> {
    List<Leaves> findByEmployeeId(Long employeeId);

}
