# Employee Management Console App - Mini Project 1

mini project for practicing core Object-Oriented Programming concepts in Java: encapsulation, inheritance, and polymorphism.

[![CI](https://github.com/Ahsec1/employee-management-console/actions/workflows/ci.yml/badge.svg)](https://github.com/Ahsec1/employee-management-console/actions/workflows/ci.yml)

## Features

- Add Developer and Manager employees (shared fields plus type-specific fields)
- List all employees in a formatted table
- Filter by type, search by department, and group by department
- Sort by department or salary using a Comparator
- Reports built with stream pipelines: top earners, average salary by department, and employees hired in the last year

## Menu

1. Add Employee
2. List Employees
3. Filter by Type
4. Sort by Department
5. Sort by Salary
6. Search by Department
7. Grouped by Department
8. Top Earners Of The Company
9. Average Salary by Department
10. Employees Hired In The Last Year
11. Exit

## Project Structure

```
src/main/java/com/example/employee_management_console_app/
  Employee.java
  Developer.java
  Manager.java
  EmployeeComparator.java
  EmployeeManager.java
  EmployeeReport.java
  EmployeeTablePrint.java
  EmployeeManagementConsoleAppApplication.java
src/main/resources/
  application.properties
src/test/java/com/example/employee_management_console_app/
  EmployeeManagementConsoleAppApplicationTests.java
```

## Design Overview
- `Employee` is an abstract class holding the shared fields (id, name, age, gender, type, salary, department, hire date). `Developer` adds a programming language and `Manager` adds a team. Each overrides the getter for its own field, and `Employee` returns null for fields that do not apply, which the table prints as "-".
- `EmployeeManager` stores employees in a `Map<Integer, Employee>` keyed by ID, so duplicate IDs are detected and lookups by ID are O(1). It exposes `getAllEmployees()` as a read-only view.
- `EmployeeComparator` implements `Comparator<Employee>` with a `SortBy` mode (`SALARY` or `DEPARTMENT`).
- `EmployeeReport` only calculates reports and prints nothing. It receives the read-only view from `EmployeeManager`, so it can read the data but never modify it.
    - `topEarners()` sorts by salary in descending order and keeps the first 10.
    - `averagePerDepartment()` uses `Collectors.groupingBy` with `Collectors.averagingDouble`, collected into a `TreeMap` so departments come out alphabetically.
    - `employeesHiredLastYear(LocalDate cutoff)` keeps employees hired on or after the cutoff and sorts them newest first. The cutoff is passed in by the caller, so the method can be tested with fixed dates.
- `EmployeeTablePrint` holds all table printing: the full employee table, the top earners table, and the average salary table.
