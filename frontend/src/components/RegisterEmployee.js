import React, { useState } from 'react';
import './RegisterEmployee.css'; 

const RegisterEmployee = () => {
  const [employee, setEmployee] = useState({
    firstName: '',
    lastName: '',
    department: '',
    email: '',
    defaultLeaveDays: 15
  });

  const [showSuccessPopup, setShowSuccessPopup] = useState(false);
  const [showErrorPopup, setShowErrorPopup] = useState(false);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setEmployee({ ...employee, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch('http://localhost:8080/employees', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(employee)
      });
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      setShowSuccessPopup(true);
    } catch (error) {
      console.error('Error registering employee:', error);
      setShowErrorPopup(true);
    }
  };

  return (
    <div className="register-employee-container">
      <h2>Register Employee</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Name:</label>
          <input
            type="text"
            name="firstName"
            value={employee.firstName}
            onChange={handleChange}
          />
        </div>
        <div className="form-group">
          <label>Last Name:</label>
          <input
            type="text"
            name="lastName"
            value={employee.lastName}
            onChange={handleChange}
          />
        </div>
        <div className="form-group">
          <label>Department:</label>
          <input
            type="text"
            name="department"
            value={employee.department}
            onChange={handleChange}
          />
        </div>
        <div className="form-group">
          <label>Email:</label>
          <input
            type="email"
            name="email"
            value={employee.email}
            onChange={handleChange}
          />
        </div>
        <div className="form-group">
          <label>Leaves:</label>
          <input
            type="number"
            name="leaves"
            value={employee.defaultLeaveDays}
            onChange={handleChange}
            disabled
          />
        </div>
        <button type="submit">Register</button>
      </form>

      {showSuccessPopup && (
        <div className="success-popup">
          <p>Employee successfully registered!</p>
          <button onClick={() => setShowSuccessPopup(false)}>Close</button>
        </div>
      )}

      {showErrorPopup && (
        <div className="error-popup">
          <p>Error registering employee. Please try again later.</p>
          <button onClick={() => setShowErrorPopup(false)}>Close</button>
        </div>
      )}
    </div>
  );
};

export default RegisterEmployee;
