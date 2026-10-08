package com.example.employee_management_console_app;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {

    public enum SortBy {
        SALARY, DEPARTMENT
    }

    private SortBy sortBy;

    public EmployeeComparator(SortBy sortBy){
        this.sortBy = sortBy;
    }

    @Override
    public int compare(Employee o1, Employee o2) {

        int salaryCompare = Double.compare(o1.getSalary(), o2.getSalary());

        if(sortBy == SortBy.DEPARTMENT){
            int departmentCompare = o1.getDepartment().compareTo(o2.getDepartment());
            return (departmentCompare == 0) ? salaryCompare : departmentCompare;
        }else{
            return salaryCompare;
        }
    }
}
