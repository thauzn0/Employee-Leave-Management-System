// AddLeaves.jsx

import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { TextField, Button } from '@mui/material';
import './AddLeaves.css';

// Get the employee id from the URL parameters
const AddLeaves = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [leaveInfo, setLeaveInfo] = useState({
    startDate: '',
    endDate: '',
    reason: '',
    employeeId: id
  });

  // Fetch employee data when component mounts or id changes
  useEffect(() => {
    fetchEmployeeData(id);
  }, [id]);

  // Function to fetch employee data from the backend
  const fetchEmployeeData = async (id) => {
    try {
      // Fetch employee data from the backend API
      const response = await fetch(`http://localhost:8080/employees/${id}`);
      if (response.ok) {
        const employeeData = await response.json();
        setLeaveInfo(prevState => ({
          ...prevState,
          employee: employeeData
        }));
      } else {
        throw new Error('Failed to fetch employee data');
      }
    } catch (error) {
      console.error('Error fetching employee data:', error);
    }
  };
  // Event handler to update leaveInfo state when input fields change
  const handleChange = (e) => {
    const { name, value } = e.target;
    setLeaveInfo(prevState => ({
      ...prevState,
      [name]: value
    }));
  };
  
  // Event handler to submit leave request to the backend
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      // Send a POST request to add leave data
      const response = await fetch(`http://localhost:8080/leaves`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(leaveInfo)
      });
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      // Navigate to the employee list page after successful submission
      navigate('/employeeList');
    } catch (error) {
      console.error('Error adding leaves:', error);
    }
  };

  return (
    <div className="add-leaves-container">
      <h2>Add Leaves</h2>
      <form onSubmit={handleSubmit} className="leave-form">
        <TextField
          label="Start Date"
          type="date"
          name="startDate"
          value={leaveInfo.startDate}
          onChange={handleChange}
          fullWidth
          margin="normal"
          InputLabelProps={{
            shrink: true,
          }}
        />
        <TextField
          label="End Date"
          type="date"
          name="endDate"
          value={leaveInfo.endDate}
          onChange={handleChange}
          fullWidth
          margin="normal"
          InputLabelProps={{
            shrink: true,
          }}
        />
        <TextField
          label="Reason"
          name="reason"
          value={leaveInfo.reason}
          onChange={handleChange}
          fullWidth
          margin="normal"
        />
        <Button variant="contained" type="submit" color="primary">
          Add Leaves
        </Button>
      </form>
    </div>
  );
};

export default AddLeaves;
