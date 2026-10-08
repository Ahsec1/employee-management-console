package com.example.employee_management_console_app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeManager {

    private Map<Integer, Employee> employees;

    public EmployeeManager(){
        employees = new HashMap<>();
    }

    private String show(Object value) {
        return value == null ? "-" : value.toString();
    }

    private String header() {
        return String.format("| %-5s | %-20s | %-3s | %-7s | %-10s | %-15s | %-12s | %-20s | %-9s |",
                "ID", "Name", "Age", "Gender", "Type", "Department", "Salary", "Programming Language", "Team Assigned");
    }

    private String row(Employee e) {
        return String.format( "| %-5d | %-20.20s | %-3d | %-7s | %-10s | %-15.15s | %-12.2f | %-20.20s | %-13s |",
                e.getId(),
                e.getName(),
                e.getAge(),
                e.getGender(),
                e.getType(),
                e.getDepartment(),
                e.getSalary(),
                show(e.getProgrammingLanguage()),
                show(e.getTeam())
        );
    }

    private void printTable(Iterable<Employee> list){
        String DIVIDER = "+-------+----------------------+-----+---------+------------+--------------+-----------------+----------------------+---------------+";
        System.out.println(DIVIDER);
        System.out.println(header());
        System.out.println(DIVIDER);
        for (Employee emp : list) {
            System.out.println(row(emp));
        }
        System.out.println(DIVIDER);
    }

    public void addEmployee(Employee employee){
        if (employees.containsKey(employee.getId())) {
            System.out.println("ID - " + employee.getId() + " already exists");
            return;
        }
        employees.put(employee.getId(), employee);
        System.out.println("Added Successfully");
    }

    public void listEmployee(){

        if(employees.isEmpty()){
            System.out.println("Empty List");
        }else{
            printTable(employees.values());
        }
    }

    public void filterEmployee(String type){
        if(employees.isEmpty()){
            System.out.println("Empty List.. Nothing to Filter");
            return;
        }

        ArrayList<Employee> matches = new ArrayList<>();
        for (Employee emp : employees.values()) {
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

    public void sortByDepartment(){
        if(employees.isEmpty()){
            System.out.println("Empty List");
            return;
        }
        List<Employee> sortedByDepartment = new ArrayList<>(employees.values());
        sortedByDepartment.sort(new EmployeeComparator(EmployeeComparator.SortBy.DEPARTMENT));
        printTable(sortedByDepartment);
    }

    public void sortBySalary(){
        if(employees.isEmpty()){
            System.out.println("Empty List");
            return;
        }
        List<Employee> sortedBySalary = new ArrayList<>(employees.values());
        sortedBySalary.sort(new EmployeeComparator(EmployeeComparator.SortBy.SALARY));
        printTable(sortedBySalary);
    }

    public void searchByDepartment(String department){
        if(employees.isEmpty()){
            System.out.println("Empty List");
            return;
        }

        Map<Integer, Employee> employee = new HashMap<>();

        for (Map.Entry<Integer, Employee> employeeEntry : employees.entrySet()) {
            if (employeeEntry.getValue().getDepartment().equals(department)) {
                employee.put(employeeEntry.getKey(), employeeEntry.getValue());
            }
        }

        if(employee.isEmpty()){
            System.out.println("No employees found in department: " + department);
        }else{
            printTable(employee.values());
        }
    }

    public void groupByDepartment(){
        if(employees.isEmpty()){
            System.out.println("Empty List");
            return;
        }

        Map<String, List<Employee>> mapDepartmentKey = new HashMap<>();

        for(Employee emp: employees.values()){
            String dept = emp.getDepartment();
            mapDepartmentKey.computeIfAbsent(dept, k -> new ArrayList<>()).add(emp);
        }

        for(Map.Entry<String, List<Employee>> emp: mapDepartmentKey.entrySet()){
            System.out.println("Department: " + emp.getKey());
            printTable(emp.getValue());
            System.out.println();
        }

    }
}
