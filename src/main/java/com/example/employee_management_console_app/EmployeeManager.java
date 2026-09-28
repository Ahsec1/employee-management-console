package com.example.employee_management_console_app;

import java.util.ArrayList;

public class EmployeeManager {

    private ArrayList<Employee> employees;

    public EmployeeManager(){
        employees = new ArrayList<>();
    }

    private String show(Object value) {
        return value == null ? "-" : value.toString();
    }

    private String header() {
        return String.format("| %-5s | %-20s | %-3s | %-7s | %-10s | %-20s | %-9s |",
                "ID", "Name", "Age", "Gender", "Type", "Programming Language", "Team Size");
    }

    private String row(Employee e) {
        return String.format("| %-5d | %-20.20s | %-3d | %-7s | %-10s | %-20.20s | %-9s |",
                e.getId(),
                e.getName(),
                e.getAge(),
                e.getGender(),
                e.getType(),
                show(e.getProgrammingLanguage()),
                show(e.getTeam()));
    }

    private void printTable(ArrayList<Employee> list){
        String DIVIDER = "+-------+----------------------+-----+---------+------------+----------------------+-----------+";
        System.out.println(DIVIDER);
        System.out.println(header());
        System.out.println(DIVIDER);
        for (Employee emp : list) {
            System.out.println(row(emp));
        }
        System.out.println(DIVIDER);
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
        System.out.println("Added Successfully");
    }

    public void listEmployee(){

        if(employees.isEmpty()){
            System.out.println("Empty List");
        }else{
            printTable(employees);
        }
    }

    public void filterEmployee(String type){
        if(employees.isEmpty()){
            System.out.println("Empty List.. Nothing to Filter");
            return;
        }

        ArrayList<Employee> matches = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getType().equals(type)) {
                matches.add(emp);
            }
        }

        if(matches.isEmpty()){
            System.out.println("No employees found with " + type + " Type");
        }else{
            printTable(matches);
        }
    }
}
