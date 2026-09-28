package com.example.employee_management_console_app;

public abstract class Employee {

    private int id;
    private String name;
    private int age;
    private String gender;
    private String type;

    public Employee (int id, String name, int age, String gender, String type){
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.type = type;
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

    public String getType(){
        return type;
    }

    public String getProgrammingLanguage() {
        return null;
    }

    public Integer getTeam() {
        return null;
    }
}

