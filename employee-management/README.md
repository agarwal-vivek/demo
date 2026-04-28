# Employee Management System

A comprehensive Spring Boot + Hibernate + H2 Employee Management System with a modern HTML/CSS/JavaScript UI.

## Features

- ✅ **Add Employees** - Create new employee records with all details
- ✅ **View Employees** - Display all employees in a responsive table
- ✅ **Edit Employees** - Update employee information
- ✅ **Delete Employees** - Remove employee records with confirmation
- ✅ **Search & Filter** - Search employees by name or ID
- ✅ **REST API** - Full REST API for CRUD operations
- ✅ **H2 Database** - Lightweight in-memory database
- ✅ **Responsive UI** - Works on desktop and mobile devices
- ✅ **Input Validation** - Client and server-side validation

## Technology Stack

- **Backend**: Spring Boot 3.1.5, Spring Data JPA, Hibernate
- **Database**: H2 (In-Memory)
- **Frontend**: HTML5, CSS3, Vanilla JavaScript
- **Build Tool**: Maven
- **Java Version**: 17+

## Project Structure

```
employee-management/
├── src/main/java/com/example/employee/
│   ├── EmployeeManagementApplication.java (Main Application)
│   ├── entity/
│   │   └── Employee.java (JPA Entity)
│   ├── repository/
│   │   └── EmployeeRepository.java (Spring Data JPA Repository)
│   ├── service/
│   │   └── EmployeeService.java (Business Logic)
│   └── controller/
│       └── EmployeeController.java (REST Endpoints)
├── src/main/resources/
│   ├── static/
│   │   ├── index.html (Main UI Page)
│   │   ├── style.css (Styling)
│   │   └── script.js (Frontend Logic)
│   └── application.properties (Configuration)
└── pom.xml (Maven Dependencies)
```

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- Any modern web browser

## Installation & Setup

### 1. Clone/Download the Project

```bash
cd employee-management
```

### 2. Build the Project

```bash
mvn clean install
```

### 3. Run the Application

```bash
mvn spring-boot:run
```

Or build and run the JAR:

```bash
mvn clean package
java -jar target/employee-management-1.0.0.jar
```

### 4. Access the Application

- **UI**: http://localhost:8080
- **H2 Console**: http://localhost:8080/api/h2-console
  - JDBC URL: `jdbc:h2:mem:employeedb`
  - Username: `sa`
  - Password: (leave empty)

## API Endpoints

### Base URL: `http://localhost:8080/api/employees`

### 1. Get All Employees
```
GET /employees
Response: 200 OK
[
  {
    "employeeId": 1,
    "firstName": "John",
    "lastName": "Doe",
    "age": 28,
    "panCardNumber": "AAAA1234A",
    "department": "IT",
    "salary": 50000
  }
]
```

### 2. Get Employee by ID
```
GET /employees/{employeeId}
Response: 200 OK
{
  "employeeId": 1,
  "firstName": "John",
  "lastName": "Doe",
  "age": 28,
  "panCardNumber": "AAAA1234A",
  "department": "IT",
  "salary": 50000
}
```

### 3. Add New Employee
```
POST /employees
Content-Type: application/json

Request Body:
{
  "firstName": "John",
  "lastName": "Doe",
  "age": 28,
  "panCardNumber": "AAAA1234A",
  "department": "IT",
  "salary": 50000
}

Response: 201 Created
{
  "employeeId": 1,
  "firstName": "John",
  "lastName": "Doe",
  "age": 28,
  "panCardNumber": "AAAA1234A",
  "department": "IT",
  "salary": 50000
}
```

### 4. Update Employee
```
PUT /employees/{employeeId}
Content-Type: application/json

Request Body:
{
  "firstName": "John",
  "lastName": "Smith",
  "age": 30,
  "panCardNumber": "AAAA1234A",
  "department": "HR",
  "salary": 60000
}

Response: 200 OK
{
  "employeeId": 1,
  "firstName": "John",
  "lastName": "Smith",
  "age": 30,
  "panCardNumber": "AAAA1234A",
  "department": "HR",
  "salary": 60000
}
```

### 5. Delete Employee
```
DELETE /employees/{employeeId}
Response: 200 OK
"Employee deleted successfully"
```

## Testing with curl

```bash
# Get all employees
curl http://localhost:8080/api/employees

# Add new employee
curl -X POST http://localhost:8080/api/employees \
  -H "Content-Type: application/json" \
  -d '{"firstName":"John","lastName":"Doe","age":28,"panCardNumber":"AAAA1234A","department":"IT","salary":50000}'

# Update employee
curl -X PUT http://localhost:8080/api/employees/1 \
  -H "Content-Type: application/json" \
  -d '{"firstName":"John","lastName":"Smith","age":30,"panCardNumber":"AAAA1234A","department":"HR","salary":60000}'

# Delete employee
curl -X DELETE http://localhost:8080/api/employees/1

# Get specific employee
curl http://localhost:8080/api/employees/1
```

## Employee Entity Details

| Field | Type | Constraints |
|-------|------|-------------|
| employeeId | Long | Primary Key, Auto-generated |
| firstName | String | Required, Not null |
| lastName | String | Required, Not null |
| age | Integer | Required, Not null, 18-70 |
| panCardNumber | String | Required, Unique, Not null |
| department | String | Required, Not null |
| salary | Double | Required, Not null, > 0 |

## Available Departments

- IT
- HR
- Finance
- Operations
- Sales
- Marketing

## Features of the UI

### Add/Edit Section
- Form with validation
- Real-time field validation
- Clear feedback on errors
- Auto-focus on first field

### Employee List Section
- Responsive table display
- Search by name or employee ID
- Edit button - Populates form with existing data
- Delete button - Confirmation dialog
- Shows "No data" message when empty

### User Experience
- Loading spinner during API calls
- Success/Error messages with auto-dismiss
- Responsive design for mobile and desktop
- Smooth scrolling to form when editing
- Currency formatting for salary display

## Configuration

Edit `src/main/resources/application.properties` to customize:

```properties
server.port=8080                                    # Change server port
spring.datasource.url=jdbc:h2:mem:employeedb      # Change database name
spring.h2.console.enabled=true                     # Enable/disable H2 console
spring.jpa.hibernate.ddl-auto=update               # Auto schema update
```

## Database

The application uses H2 in-memory database. Data is persisted during the application runtime but will be reset on restart.

To persist data to a file, change the datasource URL:
```properties
spring.datasource.url=jdbc:h2:file:~/employeedb
```

## Troubleshooting

### Port 8080 Already in Use
```bash
# Use different port
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"
```

### Build Fails
```bash
# Clean and rebuild
mvn clean install -U
```

### CORS Issues
Already configured with `@CrossOrigin(origins = "*")` in controller.

## Future Enhancements

- Authentication and Authorization
- Pagination and sorting
- Export to Excel/PDF
- Advanced search and filtering
- User roles and permissions
- Audit logging
- Email notifications
- Dashboard with statistics

## License

This project is open source and available under the MIT License.

## Author

Created as a complete Spring Boot + Hibernate + H2 Employee Management System example.
