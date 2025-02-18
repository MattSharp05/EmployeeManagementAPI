package com.challenge.api.service;

import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeImpl;
import java.util.List;
import java.util.UUID;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();  // Get all employees

    Optional<Employee> getEmployeeByUuid(UUID uuid);  // Get employee by UUID

    EmployeeImpl createEmployee(EmployeeImpl employee);  // Create a new employee
}
