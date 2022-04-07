package com.example.libraries;

import EmployeeClass.Employee;
import EmployeeServices.DepartmentService;
import EmployeeServices.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class Controller {
    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    public Controller ( DepartmentService departmentService, EmployeeService employeeService ) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee( @RequestParam("name") String firstName,
                                 @RequestParam("surname") String lastName,
                                 @RequestParam("id") int employeeDepartment,
                                 @RequestParam("pay") int employeePayment){
        Employee employee = new Employee(firstName, lastName,employeeDepartment,employeePayment);
        employeeService.addEmployee(firstName,lastName,employeeDepartment,employeePayment);
        return employee;
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("name") String firstName,
                                 @RequestParam("surname") String lastName){
        String fullName = firstName +" "+ lastName;
        employeeService.findEmployee(firstName,lastName);
        return employeeService.getEmployeeMap().get(fullName);
    }
    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("name") String firstName,
                                   @RequestParam("surname") String lastName) {
        String fullName = firstName +" "+ lastName;
        employeeService.removeEmployee(firstName,lastName);
        return employeeService.getEmployeeMap().get(fullName);
    }
    @GetMapping("/info")
    public Map<String, Employee> employeeInformation(){
        return employeeService.getEmployeeMap();
    }

    @GetMapping("/max-salary")
    public Employee getMaxSalaryEmployee(@RequestParam("id") int employeeDepartment){
        return departmentService.getMaxSalaryEmployee(employeeDepartment);
    }
    @GetMapping("/min-salary")
    public Employee getMinSalaryEmployee(@RequestParam("id") int employeeDepartment){
        return departmentService.getMinSalaryEmployee(employeeDepartment);
    }
    @GetMapping
    public List<Employee> getAllEmployees(){
        return departmentService.getAllEmployees();
    }
    @GetMapping("/all")
    public List<Employee> getAllDepartmentEmployees(@RequestParam("id") int employeeDepartment){
        return departmentService.getAllDepartmentEmployees(employeeDepartment);
    }
}
