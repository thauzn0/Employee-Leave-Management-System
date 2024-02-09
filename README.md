# Employee Leave Management System

Bu proje, bir şirkette çalışanların izin günlerini yönetmek ve raporlamak için kullanılan bir uygulamadır. Bu uygulama, Java Spring Boot ile geliştirilmiş bir backend ve React.js ile geliştirilmiş bir frontend içerir.

## Başlangıç

Bu adımları izleyerek uygulamayı yerel geliştirme ortamınızda çalıştırabilirsiniz.

### Gereksinimler

- Java 17 veya daha yeni bir sürüm
- Maven
- Node.js
- npm veya Yarn
- Git

### Yükleme

1. Depoyu klonlayın:

```bash
git clone https://github.com/thauzn0/KafeinStajProjesi.git
```

2. Backend'i çalıştırın:
```bash
cd backend
./mvnw spring-boot:run
```
Bu komut, Spring Boot uygulamasını başlatır ve http://localhost:8080 adresinde çalışır.

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

3. Frontend'i çalıştırın:
```bash
cd frontend
npm install
npm start
```
Bu komut, React uygulamasını başlatır ve http://localhost:3000 adresinde çalışır. Tarayıcınızda bu adresi açarak uygulamayı görüntüleyebilirsiniz.

# Kullanım

Uygulama başlatıldıktan sonra, http://localhost:3000 adresine giderek React frontend'ini ziyaret edebilirsiniz. Kullanıcılar sisteme giriş yapabilir, izin günlerini yönetebilir ve raporlayabilir.
