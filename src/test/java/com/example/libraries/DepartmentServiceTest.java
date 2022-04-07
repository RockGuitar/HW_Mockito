package com.example.libraries;

import EmployeeClass.Employee;
import EmployeeServices.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    private Map<String, Employee> defaultMap;
    private Employee firstEmployee;
    private Employee secondEmployee;
    private Employee thirdEmployee;
    private Employee fourthEmployee;
    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private DepartmentServiceImpl out;
    @BeforeEach
    public void setUp(){
        firstEmployee = new Employee("Ivan","Ivanov",1,100);
        secondEmployee = new Employee("Marina","Ivanova",1,300);
        thirdEmployee = new Employee("Sergey","Nikitich",2,500);
        fourthEmployee = new Employee("Anna","Dmitrievna",2,700);
        defaultMap = new HashMap<>(Map.of(
                "Ivan Ivanov", firstEmployee,
                "Marina Ivanova",secondEmployee,
                "Sergey Nikitich",thirdEmployee,
                "Anna Dmitrievna",fourthEmployee));
    }

    @Test
    void getMaxSalaryEmployee () {
        when(employeeService.getEmployeeMap()).thenReturn(defaultMap);
        assertEquals(secondEmployee,out.getMaxSalaryEmployee(1));
        assertEquals(fourthEmployee,out.getMaxSalaryEmployee(2));
        assertThrows(RuntimeException.class,()->out.getMaxSalaryEmployee(3));
    }

    @Test
    void getMinSalaryEmployee () {
        when(employeeService.getEmployeeMap()).thenReturn(defaultMap);
        assertEquals(firstEmployee,out.getMinSalaryEmployee(1));
        assertEquals(thirdEmployee,out.getMinSalaryEmployee(2));
        assertThrows(RuntimeException.class,()->out.getMaxSalaryEmployee(3));
    }

    @Test
    void getAllEmployees () {
        when(employeeService.getEmployeeMap()).thenReturn(defaultMap);
        List<Employee> expected = List.of(firstEmployee,thirdEmployee,secondEmployee,fourthEmployee);
        assertNotNull(out.getAllEmployees());
        assertEquals(out.getAllEmployees(),expected);
    }

    @Test
    void getAllDepartmentEmployees () {
        when(employeeService.getEmployeeMap()).thenReturn(defaultMap);
        List<Employee> expected = List.of(firstEmployee,secondEmployee);
        assertNotNull(out.getAllDepartmentEmployees(1));
        assertEquals(out.getAllDepartmentEmployees(1),expected);
    }
}