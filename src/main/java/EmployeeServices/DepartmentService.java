package EmployeeServices;


import EmployeeClass.Employee;

import java.util.List;


public interface DepartmentService {
    Employee getMaxSalaryEmployee ( int employeeDepartment);
    Employee getMinSalaryEmployee(int employeeDepartment);
    List<Employee> getAllEmployees();
    List<Employee> getAllDepartmentEmployees( int employeeDepartment);
}
