package com.example.employee_management_console_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagementConsoleAppApplication {

    public static void main(String[] args){
        Employee employee = new Developer( 1, "James", 12, "Male", "Developer", "Java");
        Employee employee2 = new Manager( 2,"Michaela", 15, "Female", "Manager",  1);

        System.out.println(employee);
        System.out.println(employee2);
    }

}
