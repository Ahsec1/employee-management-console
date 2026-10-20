package com.example.employee_management_console_app;

import java.util.List;
import java.util.Map;

public class EmployeeTablePrint {

    private static final String DIVIDER =
            "+-------+----------------------+-----+---------+------------+-----------------+--------------+------------+----------------------+---------------+";

    private String show(Object value) {
        return value == null ? "-" : value.toString();
    }

    private String header() {
        return String.format("| %-5s | %-20s | %-3s | %-7s | %-10s | %-15s | %-12s | %-10s | %-20s | %-13s |",
                "ID", "Name", "Age", "Gender", "Type", "Department", "Salary", "Hire Date", "Programming Language", "Team Assigned");
    }

    private String row(Employee e) {
        return String.format("| %-5d | %-20.20s | %-3d | %-7s | %-10s | %-15.15s | %-12.2f | %-10s | %-20.20s | %-13s |",
                e.getId(),
                e.getName(),
                e.getAge(),
                e.getGender(),
                e.getType(),
                e.getDepartment(),
                e.getSalary(),
                show(e.getHireDate()),
                show(e.getProgrammingLanguage()),
                show(e.getTeam())
        );
    }

    public void print(Iterable<Employee> list) {
        System.out.println(DIVIDER);
        System.out.println(header());
        System.out.println(DIVIDER);
        for (Employee emp : list) {
            System.out.println(row(emp));
        }
        System.out.println(DIVIDER);
    }

    public void printTopEarners(List<Employee> top) {
        String divider = "+------+----------------------+--------------+";

        System.out.println(divider);
        System.out.printf("| %-4s | %-20s | %-12s |%n", "Rank", "Name", "Salary");
        System.out.println(divider);

        for (int i = 0; i < top.size(); i++) {
            Employee e = top.get(i);
            System.out.printf("| %-4d | %-20.20s | %-12.2f |%n", i + 1, e.getName(), e.getSalary());
        }

        System.out.println(divider);
    }

    public void printAverageByDepartment(Map<String, Double> average) {
        String divider = "+-----------------+-----------------+";

        System.out.println(divider);
        System.out.printf("| %-15s | %-15s |%n", "Department", "Avg Salary");
        System.out.println(divider);

        average.forEach((dept, avg) ->
                System.out.printf("| %-15.15s | %-15.2f |%n", dept, avg));

        System.out.println(divider);
    }
}