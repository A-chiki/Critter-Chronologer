# 🐾 Critter Chronologer

A Spring Boot backend application for managing pet care services, including customers, pets, employees, and scheduling.

---

## 🚀 Features

- 👤 Create and manage Customers (Pet Owners)
- 🐶 Create and manage Pets
- 👨‍⚕️ Manage Employees & their Skills
- 📅 Set Employee Availability
- 🗓️ Schedule services for pets
- 🔍 Retrieve schedules by:
  - Employee
  - Pet
  - Customer

---

## 🛠️ Tech Stack

- Java 8+
- Spring Boot
- MySQL
- Maven
- JUnit (Testing)
- Postman (API Testing)

---

## ⚙️ Dependencies

Before running the project, ensure you have:

- IntelliJ IDEA (Recommended)
- Java JDK 8 or higher
- Maven
- MySQL Server 8 (or any SQL database)
- Postman

---

## 📥 Installation & Setup

### 1️⃣ Clone the Repository

git clone https://github.com/A-chiki/Critter-Chronologer.git  
cd critter-chronologer  

---

### 2️⃣ Open in IntelliJ

- Go to File → Open  
- Select the project folder  

---

### 3️⃣ Configure Database

- Install MySQL  
- Create a database  
- Create a user with full permissions  

Update `application.properties`:

spring.datasource.url=jdbc:mysql://localhost:3306/critter  
spring.datasource.username=your_username  
spring.datasource.password=your_password  

---

### 4️⃣ Run the Application

- Open `CritterApplication.java`  
- Click Run  

Visit:  
http://localhost:8082/test  

Expected Output:  
Critter Starter installed successfully  

---

## 🧪 Testing

Run the functional tests:

- Navigate to:  
  src/test/java/com.udacity.jdnd.course3.critter  

- Run:  
  CritterFunctionalTest.java  

---

## ✅ Test Cases Covered

- Create Customer  
- Create Employee  
- Add Pets to Customer  
- Find Pets by Owner  
- Find Owner by Pet  
- Change Employee Availability  
- Find Employees by Skills & Availability  
- Schedule Services  
- Retrieve Schedules  

---

## 📬 API Testing (Postman)

1. Open Postman  
2. Click Import  
3. Import:  
   src/main/resources/Udacity.postman_collection.json  

Note:  
Update IDs manually if needed based on your database  

---

## 🏗️ Built With

- Spring Boot – Backend framework  
- Google Guava – Utility libraries  
- H2 Database – Used for testing  
- MySQL Connector/J – Database connectivity  

---

## 📄 License

This project is licensed under the MIT License.

---


## 💡 Future Improvements

- Add frontend (React UI)  
- Role-based authentication (Admin/User)  
- Deployment (AWS / Render / Railway)  
- Docker support
