import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import EmployeeList from './components/EmployeeList';
import RegisterEmployee from './components/RegisterEmployee';
import UpdateEmployee from './components/UpdateEmployee';
import AddLeaves from './components/AddLeaves';
import ShowLeaves from './components/ShowLeaves';
import Header from './components/Header';

function App() {
  return (
    <Router>
      <div className="App">
   <Header />
        <main>
          <Routes>
            <Route path="/employeeList" element={<EmployeeList />} />
            <Route path="/registerEmployee" element={<RegisterEmployee />} />
            <Route path="/updateEmployee/:id" element={<UpdateEmployee />} />
            <Route path="/addLeaves/:id" element={<AddLeaves />} />
            <Route path="/showLeaves/:id" element={<ShowLeaves />} />

            <Route path="*" element={<h1>Page not found</h1>} />
            
          </Routes>
         
          
             

          
        
        </main>
      </div>
    </Router>
  );
}

export default App;

/* Add this to your CSS file */
