package com.hug0cr.webapp.service;

import com.hug0cr.webapp.model.Employee;
import com.hug0cr.webapp.repository.EmployeeProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class EmployeeService {

    @Autowired
    private EmployeeProxy employeeProxy;

    public Employee getEmployee(final int id) {
        return employeeProxy.getEmployee(id);
    }

    public Iterable<Employee> getEmployees() {
        return employeeProxy.getEmployees();
    }

    public void deleteEmployee(final int id) {
        employeeProxy.deleteEmployee(id);;
    }

    public Employee saveEmployee(Employee employee) {
        Employee savedEmployee;

        // Lastname in uppercase
        employee.setLastName(employee.getLastName().toUpperCase());

        if(employee.getId() == null) {
            // If id's null, new employee
            savedEmployee = employeeProxy.createEmployee(employee);
        } else {
            savedEmployee = employeeProxy.updateEmployee(employee);
        }

        return savedEmployee;
    }

}
