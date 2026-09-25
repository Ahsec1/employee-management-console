package com.example.employee_management_console_app;

public class Employee {

    private int id;
    private String name;
    private int age;
    private String gender;
    private String role;

    public Employee (int id, String name, int age, String gender, String role){
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getGender(){
        return gender;
    }

    public String getRole(){
        return role;
    }

    public String toString(){
        return String.format("name - %s\n", name);
    }
}

