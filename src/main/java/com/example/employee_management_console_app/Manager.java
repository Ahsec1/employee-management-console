package com.example.employee_management_console_app;

public class Manager extends Employee {

    private int team;

    public Manager (int id, String name, int age, String gender, String role, int team){
        super(id, name, age, gender, role);
        this.team = team;
    }

    public String toString(){
        return String.format("Id: %d \n" +
                        "Name: %s \n" +
                        "Age: %d \n" +
                        "Gender: %s \n" +
                        "Role: %s \n" +
                        "Team: %d \n",
                getId(),
                getName(),
                getAge(),
                getGender(),
                getRole(),
                team);
    }
}

