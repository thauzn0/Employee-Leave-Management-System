package com.taha.project.service;

import com.taha.project.entities.Employee;
import com.taha.project.entities.Leaves;
import com.taha.project.repositories.LeavesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
 * Service class for handling business logic related to Leaves entities.
 */
@Service
public class LeavesService {
    private final LeavesRepository leavesRepository;

    /*
     * Constructor injector for LeavesService.
     * @param leavesRepository An instance of LeavesRepository to perform CRUD operations on Leaves entities.
     *
     */
    public LeavesService(LeavesRepository leavesRepository) {
        this.leavesRepository = leavesRepository;
    }

    /*
     * Retrieve all leaves.
     * @return List<Leaves> representing all leaves.
     */
    public List<Leaves> getAllLeaves() {
        return leavesRepository.findAll();
    }

    /*
     * Retrieve a leave by id.
     * @param id Long representing the id of the leave to retrieve.
     * @return Leaves representing the leave with the given id, or null if not found.
     */
    public Leaves getLeavesById(Long id) {
        return leavesRepository.findById(id).orElse(null);
    }

    /*
     * Add a new leave.
     * @param leaves Leaves object representing the leave to add.
     * @return Leaves representing the added leave.
     */
    public Leaves addLeaves(Leaves leaves) {
        return leavesRepository.save(leaves);
    }

    /*
     * Update an existing leave.
     * @param id Long representing the id of the leave to update.
     * @param leaves Leaves object representing the updated information of the leave.
     * @return Leaves representing the updated leave.
     * @throws IllegalArgumentException if the leave with the given id is not found.
     */
    public Leaves updateLeaves(Long id, Leaves leaves) {
        Leaves existingLeaves = leavesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Leaves not found with this id"));
        existingLeaves.setEmployee(leaves.getEmployee());
        existingLeaves.setEndDate(leaves.getEndDate());
        existingLeaves.setStartDate(leaves.getStartDate());
        existingLeaves.setReason(leaves.getReason());
        return leavesRepository.save(existingLeaves);
    }

    /*
     * Delete a leave by id.
     * @param id Long representing the id of the leave to delete.
     */
    public void deleteLeaves(Long id) {
        leavesRepository.deleteById(id);
    }

    /*
     * Retrieve all leaves associated with a specific employee.
     * @param employeeId Long representing the id of the employee.
     * @return List<Leaves> representing all leaves associated with the given employee.
     */
    public List<Leaves> getLeavesByEmployeeId(Long employeeId) {
        return leavesRepository.findByEmployeeId(employeeId);
    }

}
