# Employee Management Console App - Mini Project 1

mini project for practicing core Object-Oriented Programming concepts in Java: encapsulation, inheritance, and polymorphism.

## Objectives

- Master the four pillars of OOP with real code, not just definitions.
- Understand when to use inheritance vs. composition.
- Write clean, well-encapsulated classes.
- Choose the right collection for the right problem. 
- Understand generics deeply enough to write type-safe reusable code.
- Use the Streams API to build reports from collections.

## Topics Covered

- Classes, objects, constructors, `this`
- Encapsulation & access modifiers
- Inheritance, `super`, method overriding vs overloading
- Polymorphism (compile-time vs run-time)
- Abstraction: abstract classes vs interfaces
- `equals()`, `hashCode()`, `toString()`
- `List`, `Set`, `Map`, `Queue`, `Deque` — implementations & complexity
- `ArrayList` vs `LinkedList`, `HashMap` vs `TreeMap` vs `LinkedHashMap`
- Comparable vs Comparator
- Generics: bounded types, wildcards (`? extends`, `? super`)
- Streams: `filter`, `sorted`, `limit`, `Collectors.groupingBy`, `Collectors.averagingDouble`

## Project Structure

Employee_Management_Console_App/
├── src/
│ ├── main
│   ├──java
│     ├── com.example.employee_management_console_app
│       ├── Developer.java
│       ├── Employee.java
│       ├── EmployeeComparator.java
│       ├── EmployeeManagementConsoleAppApplication.java
│       ├── EmployeeManager.java
│       ├── EmployeeReport.java
│       ├── EmployeeTablePrint.java
│       └── Manager.java
└── README.md

## Mini Project 1 — Phase 1

Model `Employee`, `Manager`, and `Developer` classes using inheritance and encapsulation. Store them in an `ArrayList` and print a formatted report.

### Expected Output

A working console app that adds, lists, and filters employees by type, demonstrating correct use of inheritance and polymorphism.

### `Developer.java`
- this is the developer class with states that can only be found in the developer class (e.g. programming language)
- extends `Employee` and uses `super` to pass the shared states to the parent constructor
- overrides the getter `getProgrammingLanguage()` for it to either return null or a value

### `Employee.java`
- this is the base (parent) class that holds the states shared by all employee types (e.g. id, name, salary)
- fields are private and accessed through getters and setters (encapsulation)
- includes a constructor and an overridden getter (e.g. `getProgrammingLanguage()` and `getTeam()`)

### `EmployeeManagementConsoleAppApplication.java`
- this is the entry point of the app, containing the `main` method
- handles the console menu and user input for adding, listing, and filtering employees
- creates one `EmployeeReport` and one `EmployeeTablePrint` and uses them for the report menu options

### `EmployeeManager.java`
- this class manages the collection of employees using a `Map<Integer, Employee>`, keyed by employee ID
- contains the methods for adding an employee, listing all employees, and filtering employees by type (`Manager` or `Developer`)
- contains sorting methods (`sortBySalary()`, `sortByDepartment()`) that sort a copy of the employee list using `EmployeeComparator`
- contains `searchByDepartment(String)` and `searchBySalaryRange(double, double)` for scanning the map's values by field
- contains `groupByDepartment()`, which builds a `Map<String, List<Employee>>` of employees grouped by department and display it
- prints the formatted report using the `printTable()` method and displays a table for the list, filter, sort, search, and group features
- exposes `getAllEmployees()`, a read-only view of the employees that `EmployeeReport` uses

### `Manager.java`
- this is the manager class with states that can only be found in the manager class (e.g. team)
- extends `Employee` and uses `super` to pass the shared states to the parent constructor
- overrides the getter `getTeam()` for it to either return null or a value.

## Mini Project 1 — Phase 2

Replace raw arrays with `Map<Integer, Employee>`, addsearch/sort by salary or department using `Comparator`.

### Expected Output

Console app supports sorting, searching, and grouping employees by department using a `Map<String,List<Employee>>`.

### `EmployeeComparator.java`
- implements `Comparator<Employee>` for sorting employees
- takes a `SortBy` mode (`SALARY` or `DEPARTMENT`) through its constructor, so the same class can sort by either field depending on what's passed in when it's created

## Mini Project — Phase 3

Add a reporting module using Streams — top earners, average salary by department, employees hired in the last year.

### Expected Output

Console app has a reports menu that shows the top earners, the average salary per department, and the employees hired in the last year, each calculated with a stream pipeline and printed as a table.

### `EmployeeReport.java`
- the reporting module, which only calculates the reports and prints nothing
- receives the employees as a `Collection<Employee>` through its constructor (the read-only view from `EmployeeManager.getAllEmployees()`), so it can read the data but never modify it
- `topEarners()` sorts by salary in descending order with `Comparator.comparingDouble(...).reversed()` with `limit(n)`
- `averageSalaryByDepartment()` uses `Collectors.groupingBy` with `Collectors.averagingDouble`, collected into a `TreeMap` so the departments come out in alphabetical order
- `employeesHiredLastYear(LocalDate cutoff)` uses `filter` to keep employees hired on or after the cutoff date and sorts them with the newest hire first
- the cutoff is passed in by the caller (`LocalDate.now().minusYears(1)`) instead of being read inside the stream, so the method can be tested with fixed dates

### `EmployeeTablePrint.java`
- holds all the table printing, moved out of `EmployeeManager`
- `print(Iterable<Employee>)` prints the full employee table, including the Hire Date column
- `printTopEarners(List<Employee>)` prints the rank, name, and salary table
- `printAverageByDepartment(Map<String, Double>)` prints the department and average salary table
- each table uses the same column widths in the header, rows, and divider so the borders line up
