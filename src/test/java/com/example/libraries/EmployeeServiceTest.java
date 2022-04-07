package com.example.libraries;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    @BeforeEach
    public void setUp(){
        employeeService.addEmployee("Ivan","Ivanov",2,100);
    }
    @AfterEach
    public void cleanUp(){
        if(employeeService.getEmployeeMap()!=null){
            employeeService.removeEmployee("Ivan","Ivanov");
        }
    }

    @Test
    void addEmployee () {
        assertThrows(RuntimeException.class,
                ()->employeeService.addEmployee("I4an","I6anov",2,100));
        assertThrows(RuntimeException.class,
                ()->employeeService.addEmployee("Ivan","Ivanov",2,100));
    }

    @Test
    void removeEmployee () {
        assertThrows(RuntimeException.class,()->employeeService.removeEmployee("Ivan","Ivan"));
        assertThrows(RuntimeException.class,()->employeeService.removeEmployee("Ivan","I5anov"));
    }

    @Test
    void findEmployee () {
        assertThrows(RuntimeException.class,()->employeeService.findEmployee("Ivan","Ivan"));
        assertThrows(RuntimeException.class,()->employeeService.findEmployee("Ivan","I5anov"));
    }

    @Test
    void getEmployeeMap () {
        assertNotNull(employeeService.getEmployeeMap());
    }


}