# Quick Start Guide for Employee Management System

## Step 1: Navigate to Project Directory
```bash
cd employee-management
```

## Step 2: Build the Project
```bash
mvn clean install
```

## Step 3: Run the Application
```bash
mvn spring-boot:run
```

## Step 4: Access the Application
- Open your browser and go to: **http://localhost:8080**

## Step 5: Start Managing Employees!

### To Add an Employee:
1. Fill in all the required fields in the form
2. Click "Add Employee" button
3. The employee will appear in the table below

### To Edit an Employee:
1. Click the "Edit" button next to the employee
2. The form will be populated with the employee's data
3. Make the desired changes
4. Click "Update Employee" button

### To Delete an Employee:
1. Click the "Delete" button next to the employee
2. Confirm the deletion in the popup dialog
3. The employee will be removed from the list

### To Search:
1. Use the search box above the table
2. Type the employee's name or ID
3. The table will filter in real-time

## Useful Endpoints

- **UI**: http://localhost:8080
- **Get All Employees API**: http://localhost:8080/api/employees
- **H2 Console**: http://localhost:8080/api/h2-console

## Troubleshooting

If port 8080 is already in use, run:
```bash
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"
```

Then access the application at: http://localhost:8081

## Notes
- This application uses an in-memory H2 database
- Data will be reset when the application is restarted
- All employee IDs are auto-generated
- PAN card numbers must be unique
