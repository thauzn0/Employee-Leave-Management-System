// UpdateEmployee.jsx
import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import './UpdateEmployee.css';
  

// Extracts the 'id' parameter from the URL using the useParams hook
const UpdateEmployee = () => {
  const { id } = useParams();
  const [employee, setEmployee] = useState({
    id: '',
    firstName: '',
    lastName: '',
    department: '',
    email: '',
    defaultLeaveDays: ''
  });

  const [showSuccessMessage, setShowSuccessMessage] = useState(false);

  useEffect(() => {
    fetchEmployee();
  }, []);
  // Function to fetch employee data
  const fetchEmployee = async () => {
    try {
      
      const response = await fetch(`http://localhost:8080/employees/${id}`);
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const data = await response.json();
      setEmployee(data);
    } catch (error) {
      console.error('Error fetching employee:', error);
    }
  };
  
  // Event handler to update the employee state when input fields change
  const handleChange = (e) => {
    const { name, value } = e.target;
    setEmployee(prevState => ({
      ...prevState,
      [name]: value
    }));
  };
  
  
  // Event handler to submit the updated employee data to the backend
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      
      // Sends a PUT request to update the employee data
      const response = await fetch(`http://localhost:8080/employees/${id}`, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json'
        },

        body: JSON.stringify(employee)
      });

      // Checks if the response is successful
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      
      // Sets the success message state to true
      setShowSuccessMessage(true);
    } catch (error) {
      console.error('Error updating employee:', error);
    }
  };

  return (
    <div className="update-employee-container">
      <h2>Update Employee</h2>
      <form onSubmit={handleSubmit} className="update-form">
        <TextField
          label="First Name"
          variant="outlined"
          name="firstName"
          value={employee.firstName}
          onChange={handleChange}
          fullWidth
          margin="normal"
        />
        <TextField
          label="Last Name"
          variant="outlined"
          name="lastName"
          value={employee.lastName}
          onChange={handleChange}
          fullWidth
          margin="normal"
        />
        <TextField
          label="Department"
          variant="outlined"
          name="department"
          value={employee.department}
          onChange={handleChange}
          fullWidth
          margin="normal"
        />
        <TextField
          label="Email"
          variant="outlined"
          name="email"
          value={employee.email}
          onChange={handleChange}
          fullWidth
          margin="normal"
        />
        <TextField
          label="Vacation Days"
          variant="outlined"
          name="defaultLeaveDays"
          value={employee.defaultLeaveDays}
          onChange={handleChange}
          fullWidth
          margin="normal"
        />
        <Button variant="contained" type="submit" color="primary">
          Update
        </Button>
      </form>
      
      {showSuccessMessage && (
        <div className="success-message">
          Employee successfully updated!
        </div>
      )}
    </div>
  );
};

export default UpdateEmployee;
