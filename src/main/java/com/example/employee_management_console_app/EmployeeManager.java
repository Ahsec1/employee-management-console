package com.example.employee_management_console_app;

import java.util.*;
import java.util.Collection;
import java.util.Collections;

public class EmployeeManager {

    private Map<Integer, Employee> employees;

    public EmployeeManager(){
        employees = new HashMap<>();
    }

    EmployeeTablePrint printTable = new EmployeeTablePrint();

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
            printTable.print(employees.values());
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
            printTable.print(matches);
        }
    }

    public void sortByDepartment(){
        if(employees.isEmpty()){
            System.out.println("Empty List");
            return;
        }
        List<Employee> sortedByDepartment = new ArrayList<>(employees.values());
        sortedByDepartment.sort(new EmployeeComparator(EmployeeComparator.SortBy.DEPARTMENT));
        printTable.print(sortedByDepartment);
    }

    public void sortBySalary(){
        if(employees.isEmpty()){
            System.out.println("Empty List");
            return;
        }
        List<Employee> sortedBySalary = new ArrayList<>(employees.values());
        sortedBySalary.sort(new EmployeeComparator(EmployeeComparator.SortBy.SALARY));
        printTable.print(sortedBySalary);
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
            printTable.print(employee.values());
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
            printTable.print(emp.getValue());
            System.out.println();
        }
    }

    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
