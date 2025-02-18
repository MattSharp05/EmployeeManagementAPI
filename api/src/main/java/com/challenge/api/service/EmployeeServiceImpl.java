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

    private final List<Employee> employees = new ArrayList<>(); // Mock in-memory storage

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Optional<Employee> getEmployeeByUuid(UUID uuid) {
        return employees.stream()
                .filter(employee -> employee.getUuid().equals(uuid))
                .findFirst();
    }

    @Override
    public EmployeeImpl createEmployee(EmployeeImpl employee) {
        if (employee.getUuid() == null) {
            employee.setUuid(UUID.randomUUID());
        }
        employees.add(employee);
        return employee;
    }
}
