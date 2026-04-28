# 🚀 Employee Management System - Quick Access Guide

## ✅ Application is LIVE and Running!

**Status**: 🟢 ACTIVE  
**Port**: 8080  
**Application URL**: http://localhost:8080  

---

## 🎯 Quick Links

| Function | URL |
|----------|-----|
| **Web Interface** | http://localhost:8080 |
| **REST API Base** | http://localhost:8080/api/employees |
| **H2 Database Console** | http://localhost:8080/api/h2-console |

---

## 📱 Web Interface Usage

### Adding an Employee
1. Go to: **http://localhost:8080**
2. Fill in the form:
   - First Name
   - Last Name
   - Age (18-70)
   - PAN Card Number (unique)
   - Department (dropdown)
   - Salary
3. Click **"Add Employee"**
4. See the employee appear in the table below

### Editing an Employee
1. Click the **Edit** button next to any employee
2. The form will populate with their data
3. Make your changes
4. Click **"Update Employee"**

### Deleting an Employee
1. Click the **Delete** button next to any employee
2. Confirm deletion in the popup
3. Employee removed from table

### Searching
- Use the search box above the table
- Type employee name or ID
- Results filter in real-time

---

## 💻 REST API Quick Reference

### Get All Employees
```bash
curl http://localhost:8080/api/employees
```
**Response**: JSON array of all employees

### Get Single Employee
```bash
curl http://localhost:8080/api/employees/1
```
**Response**: Single employee JSON object

### Add Employee
```bash
curl -X POST http://localhost:8080/api/employees \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "John",
    "lastName": "Doe",
    "age": 28,
    "panCardNumber": "AAAA1234A",
    "department": "IT",
    "salary": 50000
  }'
```
**Response**: Created employee with ID

### Update Employee
```bash
curl -X PUT http://localhost:8080/api/employees/1 \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "John",
    "lastName": "Smith",
    "age": 30,
    "panCardNumber": "AAAA1234A",
    "department": "HR",
    "salary": 60000
  }'
```
**Response**: Updated employee JSON

### Delete Employee
```bash
curl -X DELETE http://localhost:8080/api/employees/1
```
**Response**: Success message

---

## 📊 H2 Database Console

**URL**: http://localhost:8080/api/h2-console

**Login Details**:
- JDBC URL: `jdbc:h2:mem:employeedb`
- Username: `sa`
- Password: (leave empty)

Click "Connect" to access the database browser

---

## 📋 Available Departments

- IT
- HR
- Finance
- Operations
- Sales
- Marketing

---

## ⚙️ Server Control

### Check if Running
```bash
# Windows
netstat -ano | findstr :8080

# Linux/Mac
lsof -i :8080
```

### Stop Server
Press `Ctrl + C` in the terminal where it's running

### Restart Server
```bash
java -jar c:\Users\Riya\demo\employee-management\target\employee-management-1.0.0.jar
```

### Change Port
Edit `application.properties` and change:
```properties
server.port=8081
```

Then rebuild and restart

---

## 🧪 Test Data

Try adding these employees to test:

### Employee 1
- First Name: John
- Last Name: Doe
- Age: 28
- PAN: AAAA1234A
- Department: IT
- Salary: 50000

### Employee 2
- First Name: Jane
- Last Name: Smith
- Age: 32
- PAN: BBBB5678B
- Department: HR
- Salary: 55000

### Employee 3
- First Name: Mike
- Last Name: Johnson
- Age: 35
- PAN: CCCC9012C
- Department: Finance
- Salary: 60000

---

## 🐛 Troubleshooting

### Port 8080 is Already in Use
```bash
# Find process using port
netstat -ano | findstr :8080

# Kill the process (replace XXXX with PID)
taskkill /PID XXXX /F

# Restart application
java -jar c:\Users\Riya\demo\employee-management\target\employee-management-1.0.0.jar
```

### Application Won't Start
- Check if Java is installed: `java -version`
- Verify port 8080 is free
- Check the logs for error messages
- Ensure JAR file exists: `c:\Users\Riya\demo\employee-management\target\employee-management-1.0.0.jar`

### Database Issues
- Use H2 console to verify database
- Check table structure: `SELECT * FROM EMPLOYEES;`
- Verify unique constraint on PAN: Try adding duplicate PAN card

---

## 📁 Project Location

```
c:\Users\Riya\demo\employee-management\
```

---

## 📚 More Information

- **Full Documentation**: [README.md](./README.md)
- **Quick Start**: [QUICKSTART.md](./QUICKSTART.md)
- **Project Structure**: [PROJECT_STRUCTURE.md](./PROJECT_STRUCTURE.md)
- **Deployment Details**: [DEPLOYMENT_SUMMARY.md](./DEPLOYMENT_SUMMARY.md)

---

## ✨ Features Summary

✅ Full CRUD Operations  
✅ Web-based UI  
✅ REST API  
✅ H2 Database  
✅ Form Validation  
✅ Search Functionality  
✅ Responsive Design  
✅ Error Handling  
✅ Success Messages  
✅ Data Persistence (while running)  

---

## 🎉 You're All Set!

The Employee Management System is ready to use.

**Start managing employees now at:** 🔗 **http://localhost:8080**

---

**Last Updated**: April 28, 2026  
**Application Version**: 1.0.0  
**Status**: ✅ Live and Running
