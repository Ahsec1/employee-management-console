package com.example.employee_management_console_app;

import java.time.LocalDate;

public abstract class Employee {

    private int id;
    private String name;
    private int age;
    private String gender;
    private String type;
    private double salary;
    private String department;
    private LocalDate hireDate;

    public Employee (int id, String name, int age, String gender, String type, double salary, String department, LocalDate hireDate){
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.type = type;
        this.salary = salary;
        this.department = department;
        this.hireDate = hireDate;
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

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public String getProgrammingLanguage() {
        return null;
    }

    public Integer getTeam() {
        return null;
    }
}

