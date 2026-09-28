package com.example.employee_management_console_app;

public class Manager extends Employee {

    private int team;

    public Manager (int id, String name, int age, String gender, String type, int team){
        super(id, name, age, gender, type);
        this.team = team;
    }

    @Override
    public Integer getTeam() {
        return team;
    }
}

