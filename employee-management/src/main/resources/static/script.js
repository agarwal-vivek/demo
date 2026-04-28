// API Configuration
const API_BASE_URL = '/employees';

// DOM Elements
const employeeForm = document.getElementById('employeeForm');
const firstNameInput = document.getElementById('firstName');
const lastNameInput = document.getElementById('lastName');
const ageInput = document.getElementById('age');
const panCardInput = document.getElementById('panCardNumber');
const departmentSelect = document.getElementById('department');
const salaryInput = document.getElementById('salary');
const employeeIdInput = document.getElementById('employeeId');
const submitBtn = document.getElementById('submitBtn');
const resetBtn = document.getElementById('resetBtn');
const cancelBtn = document.getElementById('cancelBtn');
const employeeTableBody = document.getElementById('employeeTableBody');
const searchBox = document.getElementById('searchBox');
const messageBox = document.getElementById('messageBox');
const confirmModal = document.getElementById('confirmModal');
const confirmBtn = document.getElementById('confirmBtn');
const cancelConfirmBtn = document.getElementById('cancelConfirmBtn');
const noDataMessage = document.getElementById('noDataMessage');
const spinner = document.getElementById('loadingSpinner');
const formTitle = document.getElementById('formTitle');

let currentEditId = null;
let allEmployees = [];

// Initialize the application
document.addEventListener('DOMContentLoaded', () => {
    loadEmployees();
    setupEventListeners();
});

// Setup Event Listeners
function setupEventListeners() {
    employeeForm.addEventListener('submit', handleFormSubmit);
    resetBtn.addEventListener('click', resetForm);
    cancelBtn.addEventListener('click', cancelEdit);
    searchBox.addEventListener('input', handleSearch);
    confirmBtn.addEventListener('click', confirmDelete);
    cancelConfirmBtn.addEventListener('click', closeConfirmModal);
}

// Load all employees from API
async function loadEmployees() {
    showSpinner(true);
    try {
        const response = await fetch(API_BASE_URL);
        if (response.ok) {
            allEmployees = await response.json();
            displayEmployees(allEmployees);
        } else {
            showMessage('Failed to load employees', 'error');
        }
    } catch (error) {
        console.error('Error loading employees:', error);
        showMessage('Error loading employees: ' + error.message, 'error');
    } finally {
        showSpinner(false);
    }
}

// Display employees in the table
function displayEmployees(employees) {
    employeeTableBody.innerHTML = '';
    
    if (employees.length === 0) {
        noDataMessage.style.display = 'block';
        return;
    }
    
    noDataMessage.style.display = 'none';
    
    employees.forEach(employee => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${employee.employeeId}</td>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>${employee.age}</td>
            <td>${employee.panCardNumber}</td>
            <td>${employee.department}</td>
            <td>₹${parseFloat(employee.salary).toLocaleString('en-IN', { minimumFractionDigits: 2, maximumFractionDigits: 2 })}</td>
            <td>
                <div class="action-buttons">
                    <button class="btn btn-info" onclick="editEmployee(${employee.employeeId})">Edit</button>
                    <button class="btn btn-danger" onclick="deleteEmployee(${employee.employeeId}, '${employee.firstName} ${employee.lastName}')">Delete</button>
                </div>
            </td>
        `;
        employeeTableBody.appendChild(row);
    });
}

// Handle form submission (Add/Update)
async function handleFormSubmit(e) {
    e.preventDefault();
    
    if (!validateForm()) {
        return;
    }

    const employeeData = {
        firstName: firstNameInput.value.trim(),
        lastName: lastNameInput.value.trim(),
        age: parseInt(ageInput.value),
        panCardNumber: panCardInput.value.trim(),
        department: departmentSelect.value,
        salary: parseFloat(salaryInput.value)
    };

    showSpinner(true);
    try {
        let response;
        let url = API_BASE_URL;

        if (currentEditId) {
            // Update existing employee
            url = `${API_BASE_URL}/${currentEditId}`;
            response = await fetch(url, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(employeeData)
            });
        } else {
            // Create new employee
            response = await fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(employeeData)
            });
        }

        if (response.ok) {
            const message = currentEditId ? 'Employee updated successfully!' : 'Employee added successfully!';
            showMessage(message, 'success');
            resetForm();
            loadEmployees();
        } else {
            const errorData = await response.json().catch(() => ({}));
            showMessage('Error: ' + (errorData.message || 'Failed to save employee'), 'error');
        }
    } catch (error) {
        console.error('Error saving employee:', error);
        showMessage('Error: ' + error.message, 'error');
    } finally {
        showSpinner(false);
    }
}

// Validate form inputs
function validateForm() {
    if (!firstNameInput.value.trim()) {
        showMessage('First name is required', 'warning');
        return false;
    }
    if (!lastNameInput.value.trim()) {
        showMessage('Last name is required', 'warning');
        return false;
    }
    if (!ageInput.value || ageInput.value < 18 || ageInput.value > 70) {
        showMessage('Age must be between 18 and 70', 'warning');
        return false;
    }
    if (!panCardInput.value.trim()) {
        showMessage('PAN card number is required', 'warning');
        return false;
    }
    if (!departmentSelect.value) {
        showMessage('Department is required', 'warning');
        return false;
    }
    if (!salaryInput.value || salaryInput.value <= 0) {
        showMessage('Salary must be greater than 0', 'warning');
        return false;
    }
    return true;
}

// Edit employee - populate form
async function editEmployee(employeeId) {
    showSpinner(true);
    try {
        const response = await fetch(`${API_BASE_URL}/${employeeId}`);
        if (response.ok) {
            const employee = await response.json();
            
            // Populate form
            employeeIdInput.value = employee.employeeId;
            firstNameInput.value = employee.firstName;
            lastNameInput.value = employee.lastName;
            ageInput.value = employee.age;
            panCardInput.value = employee.panCardNumber;
            departmentSelect.value = employee.department;
            salaryInput.value = employee.salary;
            
            // Update UI for edit mode
            currentEditId = employeeId;
            formTitle.textContent = `Edit Employee - ${employee.firstName} ${employee.lastName}`;
            submitBtn.textContent = 'Update Employee';
            cancelBtn.style.display = 'inline-block';
            
            // Scroll to form
            document.querySelector('.form-section').scrollIntoView({ behavior: 'smooth' });
        } else {
            showMessage('Failed to load employee', 'error');
        }
    } catch (error) {
        console.error('Error loading employee:', error);
        showMessage('Error: ' + error.message, 'error');
    } finally {
        showSpinner(false);
    }
}

// Delete employee
function deleteEmployee(employeeId, employeeName) {
    const confirmMessage = document.getElementById('confirmMessage');
    confirmMessage.textContent = `Are you sure you want to delete employee "${employeeName}"?`;
    confirmBtn.onclick = () => {
        performDelete(employeeId);
    };
    confirmModal.classList.add('show');
}

// Perform actual delete
async function performDelete(employeeId) {
    closeConfirmModal();
    showSpinner(true);
    try {
        const response = await fetch(`${API_BASE_URL}/${employeeId}`, {
            method: 'DELETE'
        });
        
        if (response.ok) {
            showMessage('Employee deleted successfully!', 'success');
            loadEmployees();
        } else {
            showMessage('Failed to delete employee', 'error');
        }
    } catch (error) {
        console.error('Error deleting employee:', error);
        showMessage('Error: ' + error.message, 'error');
    } finally {
        showSpinner(false);
    }
}

// Cancel editing
function cancelEdit() {
    resetForm();
}

// Reset form
function resetForm() {
    employeeForm.reset();
    employeeIdInput.value = '';
    currentEditId = null;
    formTitle.textContent = 'Add New Employee';
    submitBtn.textContent = 'Add Employee';
    cancelBtn.style.display = 'none';
}

// Search functionality
function handleSearch(e) {
    const searchTerm = e.target.value.toLowerCase();
    const filteredEmployees = allEmployees.filter(emp => 
        emp.firstName.toLowerCase().includes(searchTerm) ||
        emp.lastName.toLowerCase().includes(searchTerm) ||
        emp.employeeId.toString().includes(searchTerm)
    );
    displayEmployees(filteredEmployees);
}

// Show/Hide spinner
function showSpinner(show) {
    spinner.style.display = show ? 'flex' : 'none';
}

// Show messages
function showMessage(text, type) {
    const messageDiv = document.createElement('div');
    messageDiv.className = `message ${type}`;
    messageDiv.textContent = text;
    messageBox.appendChild(messageDiv);
    
    // Auto-remove after 5 seconds
    setTimeout(() => {
        messageDiv.remove();
    }, 5000);
}

// Close confirm modal
function closeConfirmModal() {
    confirmModal.classList.remove('show');
}
