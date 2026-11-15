package com.example.employee_management_console_app;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeReport {

    private Collection<Employee> employees;

    public EmployeeReport(Collection<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> topEarners(){
        return employees.stream().sorted(new EmployeeComparator(EmployeeComparator.SortBy.SALARY).reversed()).limit(10).toList();
    }
    ;
    public Map<String, Double> averagePerDepartment(){
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, TreeMap::new, Collectors.averagingDouble(Employee::getSalary)));
    }

    public List<Employee> employeesHiredLastYear(LocalDate cutoff) {
        return employees.stream().filter(e -> !e.getHireDate().isBefore(cutoff)).sorted(Comparator.comparing(Employee::getHireDate).reversed()).toList();
    }
}
