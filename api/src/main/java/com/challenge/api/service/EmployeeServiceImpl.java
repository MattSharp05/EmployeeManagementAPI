package com.challenge.api.service;

import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // In-memory storage for employees (simulates a database)
    private final List<Employee> employees = new ArrayList<>();

    /**
     * Retrieves all employees.
     *
     * @return a list of all employees
     */
    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    /**
     * Retrieves an employee by their UUID.
     *
     * @param uuid the UUID of the employee
     * @return an Optional containing the employee if found, otherwise empty
     */
    @Override
    public Optional<Employee> getEmployeeByUuid(UUID uuid) {
        return employees.stream()
                .filter(employee -> employee.getUuid().equals(uuid))
                .findFirst();
    }

    /**
     * Creates a new employee and assigns a UUID if not provided.
     *
     * @param employee the employee to be created
     * @return the created employee with a UUID
     */
    @Override
    public EmployeeImpl createEmployee(EmployeeImpl employee) {
        if (employee.getUuid() == null) {
            employee.setUuid(UUID.randomUUID());
        }
        employees.add(employee);
        return employee;
    }
}
