import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import './ShowLeaves.css'; 

const ShowLeaves = () => {
  const { id } = useParams();
  const [leaves, setLeaves] = useState([]);

  useEffect(() => {
    fetchLeaves();
  }, [id]);

  const fetchLeaves = async () => {
    try {
      const response = await fetch(`http://localhost:8080/leaves/employee/${id}/leaves`);
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const data = await response.json();
      setLeaves(data);
    } catch (error) {
      console.error('Error fetching leaves:', error);
    }
  };

  const handleDeleteLeave = async (leaveId) => {
    try {
      const response = await fetch(`http://localhost:8080/leaves/${leaveId}`, {
        method: 'DELETE',
      });
      if (!response.ok) {
        throw new Error('Failed to delete leave');
      }
      
      setLeaves(prevLeaves => prevLeaves.filter(leave => leave.id !== leaveId));
    
    } catch (error) {
      console.error('Error deleting leave:', error);
    }
  };

  return (
    <div className="show-leaves-container">
      <h2>Leaves for Employee ID: {id}</h2>
      <table className="leaves-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Reason</th>
            <th>Action</th> {}
          </tr>
        </thead>
        <tbody>
          {leaves.map(leave => (
            <tr key={leave.id}>
              <td>{leave.id}</td>
              <td>{leave.startDate}</td>
              <td>{leave.endDate}</td>
              <td>{leave.reason}</td>
              <td>
                <button onClick={() => handleDeleteLeave(leave.id)}>Delete</button>
              </td> {}
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ShowLeaves;
