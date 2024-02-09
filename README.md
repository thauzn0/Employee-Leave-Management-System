# Employee Leave Management System

This project is an application used to manage and report vacation days of employees in a company. This application includes a backend developed with Java Spring Boot and a frontend developed with React.js.

## Starting

Follow this steps to running app in local.

### Requirements

- Java 17 
- Maven
- Node.js
- npm veya Yarn
- Git

### Downloading

1. Clone repo:

```bash
git clone https://github.com/thauzn0/KafeinStajProjesi.git
```

2. Run backend:
```bash
./mvnw spring-boot:run
```
This command, starting Spring boot project and running on  http://localhost:8080 address.

Endpoints

/leaves [GET] Endpoint to retrieve all leaves.

/leaves [POST]    Endpoint to add a new leave.

/leaves/employee/{employeeId}/leaves [GET] Endpoint to retrieve all leaves for a specific employee.

/leaves/{id} [GET] Endpoint to retrieve a leave by id.

/leaves/{id}[PUT]  Endpoint to update an existing leave.

/leaves/{id} [DELETE] Endpoint to delete a leave by id.

/employees [GET] Endpoint to retrieve all employees.

/employees [POST] Endpoint to add a new employee.

/employees/{id} [GET] Endpoint to retrieve an employee by id.

/employees/{id} [PUT] Endpoint to update an existing employee.

/employees/{id} [DELETE] Endpoint to delete an employee by id.

3. Run Frontend:
```bash
cd frontend
npm install
npm start
```
This command , starting React app and running on http://localhost:3000 adress. You can open this address in your browser and use.

# Kullanım

After app starting, going to this http://localhost:3000 adress You can see frontend which programmed with React.
