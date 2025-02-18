package com.challenge.api.service;
import java.util.Optional;


import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employees = new ArrayList<>(); // Mock in-memory storage

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Optional <Employee> getEmployeeByUuid(UUID uuid) {
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
