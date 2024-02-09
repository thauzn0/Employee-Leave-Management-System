import React, { useState, useEffect } from 'react';
import './EmployeeList.css';
import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';
import { Link } from 'react-router-dom';
// Get the all employee  
const EmployeeList = () => {
  const [employees, setEmployees] = useState([]);
  const [searchTerm, setSearchTerm] = useState('');


  // Fetch employees data
  useEffect(() => {
    fetchEmployees();
  }, []);

  // Function to fetch employee data from the backend
  const fetchEmployees = async () => {
    try {
      // Fetch employee data from the backend API
      const response = await fetch('http://localhost:8080/employees');
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const data = await response.json();
      setEmployees(data);
    } catch (error) {
      console.error('Error fetching employees:', error);
    }
  };

  const handleSearchChange = (e) => {
    setSearchTerm(e.target.value);
  };

  const filteredEmployees = employees.filter(employee =>
    `${employee.firstName} ${employee.lastName} ${employee.department} ${employee.email}`
      .toLowerCase()
      .includes(searchTerm.toLowerCase())
  );

  const handleDeleteEmployee = async (id) => {
    try {
      // Send a DELETE request to add leave data
      const response = await fetch(`http://localhost:8080/employees/${id}`, {
        method: 'DELETE',
      });
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      // Remove the deleted employee from the state
      setEmployees(employees.filter(employee => employee.id !== id));
    } catch (error) {
      console.error('Error deleting employee:', error);
    }
  };

  return (
    <div className="employee-list-container">
      <h2>Employee List</h2>
      <input
        type="text"
        placeholder="Search"
        value={searchTerm}
        onChange={handleSearchChange}
        className="search-input"
      />

      <table className="employee-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Last Name</th>
            <th>Department</th>
            <th>Mail</th>
            <th>Vacation Days</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {filteredEmployees.map(employee => (
            <tr key={employee.id}>
              <td>{employee.id}</td>
              <td>{employee.firstName}</td>
              <td>{employee.lastName}</td>
              <td>{employee.department}</td>
              <td>{employee.email}</td>
              <td>{employee.defaultLeaveDays}</td>
              <td>
                {/* Update link */}
                <Button variant="contained">
                  <Link to={`/updateEmployee/${employee.id}`} className="button" style={{ textDecoration: 'none', color: '#ffffff' }}>Edit</Link>
                </Button>
                {/* Delete button */}
                <Button variant='contained' onClick={() => handleDeleteEmployee(employee.id)}>Delete</Button>
                {/* Add Leaves button */}
                <Button variant="contained">
                <Link to={`/addLeaves/${employee.id}`} className="button" style={{ textDecoration: 'none', color: '#ffffff' }}>Add Leaves</Link>
                </Button>
                {/* Show Leaves button */}
                <Button variant="contained">
                  <Link to={`/showLeaves/${employee.id}`} className="button" style={{ textDecoration: 'none', color: '#ffffff' }}>Show Leaves</Link>
                </Button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <Button variant="contained">
        <Link to="/registerEmployee" className="button" style={{ textDecoration: 'none', marginLeft: 'auto', color: '#ffffff' }}>Register Employee</Link>
      </Button>

    </div>
  );
};

export default EmployeeList;
