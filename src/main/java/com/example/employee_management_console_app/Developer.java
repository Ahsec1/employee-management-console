package com.example.employee_management_console_app;

import java.time.LocalDate;

public class Developer extends Employee {

    private String programming_language;

    public Developer(int id, String name, int age, String gender, String type, String programming_language, double salary, String department, LocalDate hireDate){
        super(id, name, age, gender, type, salary, department, hireDate);
        this.programming_language = programming_language;
    }

    @Override
    public String getProgrammingLanguage() {
        return programming_language;
    }
}

