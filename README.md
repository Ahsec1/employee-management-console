# Employee Management Console App (Phase 1)

mini project for practicing core Object-Oriented Programming concepts in Java: encapsulation, inheritance, and polymorphism.

## Objectives

- Master the four pillars of OOP with real code, not just definitions.
- Understand when to use inheritance vs. composition.
- Write clean, well-encapsulated classes.
- Choose the right collection for the right problem. 
- Understand generics deeply enough to write type-safe reusable code.

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
│       └── EmployeeManager.java
│       └── Manager.java
└── README.md

## Mini Project — Phase 1

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

### `EmployeeManager.java`
- this class manages the collection of employees using a `Map<Integer, Employee>`, keyed by employee ID
- contains the methods for adding an employee, listing all employees, and filtering employees by type (`Manager` or `Developer`)
- contains sorting methods (`sortBySalary()`, `sortByDepartment()`) that sort a copy of the employee list using `EmployeeComparator`
- contains `searchByDepartment(String)` and `searchBySalaryRange(double, double)` for scanning the map's values by field
- contains `groupByDepartment()`, which builds a `Map<String, List<Employee>>` of employees grouped by department and display it
- prints the formatted report using the `printTable()` method and displays a table for the list, filter, sort, search, and group features

### `Manager.java`
- this is the manager class with states that can only be found in the manager class (e.g. team)
- extends `Employee` and uses `super` to pass the shared states to the parent constructor
- overrides the getter `getTeam()` for it to either return null or a value.

## Mini Project — Phase 2

Replace raw arrays with `Map<Integer, Employee>`, addsearch/sort by salary or department using `Comparator`.

### Expected Output

Console app supports sorting, searching, and grouping employees by department using a `Map<String,List<Employee>>`.

### `EmployeeComparator.java`
- implements `Comparator<Employee>` for sorting employees
- takes a `SortBy` mode (`SALARY` or `DEPARTMENT`) through its constructor, so the same class can sort by either field depending on what's passed in when it's created
