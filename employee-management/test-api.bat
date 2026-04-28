@echo off
REM API Testing Commands for Employee Management System (Windows)

setlocal enabledelayedexpansion
set API_URL=http://localhost:8080/api/employees

echo =====================================
echo Employee Management System - API Tests
echo =====================================

REM Test 1: Get all employees
echo.
echo 1. GET All Employees
echo Command: curl %API_URL%
curl -X GET %API_URL%
echo.

REM Test 2: Add a new employee
echo.
echo 2. POST - Add New Employee
echo Command: curl -X POST...
curl -X POST %API_URL% ^
  -H "Content-Type: application/json" ^
  -d "{\"firstName\": \"John\", \"lastName\": \"Doe\", \"age\": 28, \"panCardNumber\": \"AAAA1234A\", \"department\": \"IT\", \"salary\": 50000}"
echo.

REM Test 3: Add another employee
echo.
echo 3. POST - Add Another Employee
curl -X POST %API_URL% ^
  -H "Content-Type: application/json" ^
  -d "{\"firstName\": \"Jane\", \"lastName\": \"Smith\", \"age\": 32, \"panCardNumber\": \"BBBB5678B\", \"department\": \"HR\", \"salary\": 55000}"
echo.

REM Test 4: Get specific employee (ID 1)
echo.
echo 4. GET - Get Employee by ID
echo Command: curl %API_URL%/1
curl -X GET %API_URL%/1
echo.

REM Test 5: Update employee
echo.
echo 5. PUT - Update Employee
echo Command: curl -X PUT %API_URL%/1 ...
curl -X PUT %API_URL%/1 ^
  -H "Content-Type: application/json" ^
  -d "{\"firstName\": \"John\", \"lastName\": \"Smith\", \"age\": 30, \"panCardNumber\": \"AAAA1234A\", \"department\": \"IT\", \"salary\": 60000}"
echo.

REM Test 6: Get all employees again
echo.
echo 6. GET All Employees (after update)
curl -X GET %API_URL%
echo.

REM Test 7: Delete employee
echo.
echo 7. DELETE - Delete Employee
echo Command: curl -X DELETE %API_URL%/2
curl -X DELETE %API_URL%/2
echo.

REM Test 8: Get all employees (final)
echo.
echo 8. GET All Employees (after delete)
curl -X GET %API_URL%
echo.

echo =====================================
echo Tests completed!
echo =====================================
pause
