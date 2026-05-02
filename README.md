🏥 MedSecure HMS – Backend

Secure Hospital Management System using Spring Boot & Role-Based Access Control

📌 Overview

MedSecure HMS is a backend application built using Spring Boot to manage hospital operations securely.

It provides REST APIs for managing hospitals, users, and authentication with role-based access control (RBAC).

🚀 Features
🔐 Authentication
User Registration
Login System
Role-based authorization
👤 User Management
Get all users (Admin)
Get user by ID
Update user
Delete user
🏥 Hospital Management
Register hospital
Get all hospitals
Get hospital by ID
Update hospital details
Delete hospital
🧠 Roles
Role	Access
PUBLIC	View data
DOCTOR	Update hospital
ADMIN	Full access
📡 API Endpoints
🔐 Auth APIs
POST /auth/register
POST /auth/login
👤 User APIs
GET    /user/apis/ADMIN/all
GET    /user/apis/PUBLIC/{id}
PUT    /user/apis/ADMIN/update/{id}
DELETE /user/apis/ADMIN/delete/{id}
🏥 Hospital APIs
POST   /api/v1/hospitals
GET    /api/v1/hospitals
GET    /api/v1/hospitals/PUBLIC/{id}
PUT    /api/v1/hospitals/DOCTOR/{id}
DELETE /api/v1/hospitals/ADMIN/{id}
🧑‍💻 Tech Stack
Backend: Java + Spring Boot
Architecture: REST APIs
Database: MySQL
Build Tool: Maven
📂 Project Structure
medsecure-hms/
│
├── Controller/
├── Services/
├── Model/
├── Dtos/
├── Repository/
└── Application.java
⚙️ Setup
git clone https://github.com/GulamHasan01/medsecure-hms.git
cd medsecure-hms
mvn spring-boot:run
🔐 Security
Role-based API access
DTO-based request handling
Layered architecture
👨‍💻 Author

Gulam Hasan
GitHub: https://github.com/GulamHasan01

LinkedIn: https://linkedin.com/in/gulam-hasan-80751a330
