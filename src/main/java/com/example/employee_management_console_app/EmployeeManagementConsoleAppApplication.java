package com.example.employee_management_console_app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

@SpringBootApplication
public class EmployeeManagementConsoleAppApplication {

    static void main(){

        EmployeeManager manageEmployee = new EmployeeManager();
        EmployeeReport report = new EmployeeReport(manageEmployee.getAllEmployees());
        EmployeeTablePrint printTable = new EmployeeTablePrint();

        Scanner scanner = new Scanner(System.in);

        boolean check = true;

        do {
            System.out.println("\n=================================");
            System.out.println("     EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Employee");
            System.out.println("2. List Employees");
            System.out.println("3. Filter by Type");
            System.out.println("4. Sort by Department");
            System.out.println("5. Sort by Salary");
            System.out.println("6. Search by Department");
            System.out.println("7. Grouped by Department");
            System.out.println("8. Top Earners Of The Company");
            System.out.println("9. Average Salary by Department");
            System.out.println("10. Employees Hired In The Last Year");
            System.out.println("11. Exit");
            System.out.println("=================================");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.println("------Fill Out The Form--------\n");

                    System.out.print("ID: ");
                    int id = scanner.nextInt();

                    System.out.print("Name: ");
                    String name = scanner.next();

                    System.out.print("Age: ");
                    int age = scanner.nextInt();

                    System.out.print("Gender: ");
                    String gender = scanner.next();

                    System.out.print("Salary: ");
                    double salary = scanner.nextDouble();

                    System.out.print("Department: ");
                    String department = scanner.next();

                    LocalDate hireDate = null;

                    while (hireDate == null) {
                        System.out.print("Hire Date (yyyy-MM-dd): ");
                        String input = scanner.next();

                        try {
                            hireDate = LocalDate.parse(input);
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date. Use the format yyyy-MM-dd, for example 2025-03-15.");
                        }
                    }

                    boolean wrongInput = true;

                    do {
                        System.out.println("1. Developer: ");
                        System.out.println("2. Manager: ");
                        System.out.print("Choose Type: ");
                        int type = scanner.nextInt();

                        switch(type){
                            case 1:
                                System.out.println("Programming Language: ");
                                String language = scanner.next();

                                Developer developer = new Developer(
                                        id,
                                        name,
                                        age,
                                        gender,
                                        "Developer",
                                        language,
                                        salary,
                                        department,
                                        hireDate
                                );
                                manageEmployee.addEmployee(developer);
                                wrongInput = false;
                                break;
                            case 2:
                                System.out.println("team Assigned (eg. 010): ");
                                int team = scanner.nextInt();

                                Manager manager = new Manager(
                                        id,
                                        name,
                                        age,
                                        gender,
                                        "Manager",
                                        team,
                                        salary,
                                        department,
                                        hireDate
                                );
                                manageEmployee.addEmployee(manager);
                                wrongInput = false;
                                break;
                            default:
                                System.out.println("Invalid Input");
                        }

                    } while (wrongInput);
                    scanner.nextLine();
                    break;

                case 2:
                    System.out.println();
                    System.out.println();

                    System.out.println("LIST OF EMPLOYEES");

                    manageEmployee.listEmployee();
                    break;

                case 3:
                    System.out.println("------FILTERING EMPLOYEES BY TYPE-------");
                    System.out.println("1. Developer: ");
                    System.out.println("2. Manager: ");
                    System.out.print("Choose Type: ");
                    int type = scanner.nextInt();

                    switch (type) {
                        case 1:
                            manageEmployee.filterEmployee("Developer");
                            break;
                        case 2:
                            manageEmployee.filterEmployee("Manager");
                            break;
                        default:
                            System.out.println("Invalid Input");
                    }
                    scanner.nextLine();
                    break;

                case 4:
                    System.out.println("------SORTING BY DEPARTMENT-------");
                    manageEmployee.sortByDepartment();
                    break;

                case 5:
                    System.out.println("------SORTING BY SALARY-------");
                    manageEmployee.sortBySalary();
                    break;

                case 6:
                    System.out.println("------SEARCH BY DEPARTMENT-------");
                    System.out.print("Enter department: ");
                    String searchDept = scanner.next();
                    manageEmployee.searchByDepartment(searchDept);
                    scanner.nextLine();
                    break;

                case 7:
                    System.out.println("------GROUP BY DEPARTMENT-------");
                    manageEmployee.groupByDepartment();
                    break;

                case 8:
                    System.out.println("------TOP EARNERS-------");

                    List<Employee> topEmployee = report.topEarners();

                    if (topEmployee.isEmpty()) {
                        System.out.println("Empty List");
                    } else {
                        printTable.printTopEarners(topEmployee);
                    }

                    break;

                case 9:
                    System.out.println("------AVERAGE SALARY BY DEPARTMENT-------");

                    Map<String, Double> average = report.averagePerDepartment();

                    if (average.isEmpty()) {
                        System.out.println("Empty List");
                    }else{
                        printTable.printAverageByDepartment(average);
                    }
                    break;

                case 10:
                    System.out.println("------HIRED IN THE LAST YEAR-------");

                    List<Employee> recentEmployees = report.employeesHiredLastYear(LocalDate.now().minusYears(1));

                    if (recentEmployees.isEmpty()){
                        System.out.println("Empty List");
                    }else{
                        printTable.print(recentEmployees);
                    }

                    break;

                case 11:
                    check = false;
                    System.out.println("Exiting program..");
                    break;

                default:
                    System.out.println("Invalid Option");
            }
            if (check) {
                System.out.print("\nPress Enter to continue...");
                scanner.nextLine();
            }
        } while (check);

    }

}
