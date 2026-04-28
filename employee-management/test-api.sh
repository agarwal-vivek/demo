#!/bin/bash
# API Testing Commands for Employee Management System

API_URL="http://localhost:8080/api/employees"

echo "====================================="
echo "Employee Management System - API Tests"
echo "====================================="

# Test 1: Get all employees
echo -e "\n1. GET All Employees"
echo "Command: curl $API_URL"
curl -X GET $API_URL
echo -e "\n"

# Test 2: Add a new employee
echo -e "\n2. POST - Add New Employee"
echo "Command: curl -X POST..."
curl -X POST $API_URL \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "John",
    "lastName": "Doe",
    "age": 28,
    "panCardNumber": "AAAA1234A",
    "department": "IT",
    "salary": 50000
  }'
echo -e "\n"

# Test 3: Add another employee
echo -e "\n3. POST - Add Another Employee"
curl -X POST $API_URL \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Jane",
    "lastName": "Smith",
    "age": 32,
    "panCardNumber": "BBBB5678B",
    "department": "HR",
    "salary": 55000
  }'
echo -e "\n"

# Test 4: Get specific employee (ID 1)
echo -e "\n4. GET - Get Employee by ID"
echo "Command: curl $API_URL/1"
curl -X GET $API_URL/1
echo -e "\n"

# Test 5: Update employee
echo -e "\n5. PUT - Update Employee"
echo "Command: curl -X PUT $API_URL/1 ..."
curl -X PUT $API_URL/1 \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "John",
    "lastName": "Smith",
    "age": 30,
    "panCardNumber": "AAAA1234A",
    "department": "IT",
    "salary": 60000
  }'
echo -e "\n"

# Test 6: Get all employees again
echo -e "\n6. GET All Employees (after update)"
curl -X GET $API_URL
echo -e "\n"

# Test 7: Delete employee
echo -e "\n7. DELETE - Delete Employee"
echo "Command: curl -X DELETE $API_URL/2"
curl -X DELETE $API_URL/2
echo -e "\n"

# Test 8: Get all employees (final)
echo -e "\n8. GET All Employees (after delete)"
curl -X GET $API_URL
echo -e "\n"

echo "====================================="
echo "Tests completed!"
echo "====================================="
