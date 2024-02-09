import React from 'react';
import { Link } from 'react-router-dom';
import './Header.css'; // Header bileşeni için CSS dosyası

const Header = () => {
  return (
    <header className="header">
      <nav className="navbar">
        <div className="navbar-container">
          <Link to="/registerEmployee" className="navbar-link">Register Employee</Link>
          <Link to="/employeeList" className="navbar-link">Employee List</Link>
        </div>
      </nav>
    </header>
  );
};

export default Header;
