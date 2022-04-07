package com.example.libraries;

import EmployeeClass.Employee;
import EmployeeErrors.EmployeeAlreadyExists;
import EmployeeErrors.EmployeeNotFound;
import EmployeeErrors.EmployeeWrongName;
import EmployeeServices.DepartmentService;
import EmployeeServices.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;
    public DepartmentServiceImpl(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    public List<Employee> getAllEmployees () {
        return employeeService.getEmployeeMap().values().stream()
                .collect(Collectors.toList());
    }
    public List<Employee> getAllDepartmentEmployees(int employeeDepartment){
        return employeeService.getEmployeeMap().values().stream()
                .filter(employee-> employee.getEmployeeDepartment()==employeeDepartment)
                .collect(Collectors.toList());
    };
    public Employee getMaxSalaryEmployee (int employeeDepartment){
        return employeeService.getEmployeeMap().values().stream()
                .filter(employee-> employee.getEmployeeDepartment()==employeeDepartment)
                .max(Comparator.comparing(Employee::getEmployeePayment))
                .get();
    }
    public Employee getMinSalaryEmployee(int employeeDepartment){
        return employeeService.getEmployeeMap().values().stream()
                .filter(employee-> employee.getEmployeeDepartment()==employeeDepartment)
                .min(Comparator.comparing(Employee::getEmployeePayment))
                .get();
    }


}
