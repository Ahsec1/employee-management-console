package com.example.employee_management_console_app;

import java.time.LocalDate;

public class Manager extends Employee {

    private int team;

    public Manager (int id, String name, int age, String gender, String type, int team, double salary, String department, LocalDate hireDate){
        super(id, name, age, gender, type, salary, department, hireDate);
        this.team = team;
    }

    @Override
    public Integer getTeam() {
        return team;
    }
}

