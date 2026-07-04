# Payroll Management System

A simple **Payroll Management System** developed using **Java, MySQL, and JDBC**. This application helps organizations manage employee records and automate payroll calculations efficiently.

---

## 📌 Features

* Add new employee details
* View all employee records
* Update employee information
* Delete employee records
* Generate payroll automatically
* Calculate:

  * Basic Salary
  * HRA (House Rent Allowance)
  * DA (Dearness Allowance)
  * Deductions
  * Net Salary
* Prevent duplicate payroll generation
* Store payroll details in a MySQL database
* Simple and easy-to-understand project structure

---

## 🛠️ Technologies Used

* Java
* JDBC (Java Database Connectivity)
* MySQL
* VS Code / Eclipse / IntelliJ IDEA
* MySQL Connector/J

---

## 📂 Project Structure

```text
PayrollManagementSystem/
│
├── src/
│   ├── model/
│   │   ├── Employee.java
│   │   └── Payroll.java
│   │
│   ├── dao/
│   │   ├── EmployeeDAO.java
│   │   ├── PayrollDAO.java
│   │   └── DBConnection.java
│   │
│   ├── ui/
│   │   └── Main.java
│   │
│   └── utils/
│
├── database/
│   └── payroll.sql
│
├── lib/
│   └── mysql-connector-j.jar
│
└── README.md
```

---

## 🗄️ Database

Create a MySQL database named:

```sql
CREATE DATABASE payroll;
```

Import the SQL file provided in the `database` folder.

Update the database credentials inside `DBConnection.java`.

```java
String url = "jdbc:mysql://localhost:3306/payroll";
String username = "root";
String password = "your_password";
```

---

## ⚙️ Payroll Formula

The system calculates salary using the following formula:

```
HRA = 20% of Basic Salary

DA = 10% of Basic Salary

Deductions = 5% of Basic Salary

Net Salary = Basic Salary + HRA + DA − Deductions
```

Example:

| Component       | Amount (₹) |
| --------------- | ---------: |
| Basic Salary    |     30,000 |
| HRA (20%)       |      6,000 |
| DA (10%)        |      3,000 |
| Deductions (5%) |      1,500 |
| **Net Salary**  | **37,500** |

---

## 🚀 How to Run

1. Clone the repository.

```bash
git clone https://github.com/your-username/PayrollManagementSystem.git
```

2. Open the project in your preferred Java IDE.

3. Add the MySQL Connector/J JAR file to the project libraries.

4. Create the MySQL database and import the SQL file.

5. Update the database credentials in `DBConnection.java`.

6. Run the `Main.java` file.

---

## 📸 Screenshots

You can add screenshots here after uploading your project.

* Home Screen
* Add Employee
* Employee List
* Payroll Generation
* Payroll Report

---

## 🔮 Future Enhancements

* Java Swing GUI
* Employee Login
* Admin Dashboard
* Attendance Management
* Leave Management
* PDF Salary Slip Generation
* Email Salary Slips
* Export Payroll Reports to Excel
* Role-Based Authentication

---

## 🎯 Learning Outcomes

This project demonstrates:

* Object-Oriented Programming (OOP)
* JDBC Connectivity
* CRUD Operations
* MySQL Database Management
* Payroll Calculation Logic
* Java Project Structure
* Exception Handling

---

## 🤝 Contributing

Contributions are welcome.

1. Fork the repository.
2. Create a new branch.
3. Commit your changes.
4. Push to your branch.
5. Open a Pull Request.

---

## 📄 License

This project is developed for educational purposes. You are free to use and modify it for learning.

---

## 👨‍💻 Author

**Sujal Raj**

* B.Tech Computer Science Engineering
* Java | MySQL | JDBC
* GitHub: https://github.com/sujalraj-2
* LinkedIn: (https://www.linkedin.com/in/sujal-raj-22aa29327/)
---

⭐ If you found this project useful, please consider giving it a **Star** on GitHub.
