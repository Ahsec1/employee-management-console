public class Main {

    public static void main (){
        Employee employee = new Developer( 1, "James", 12, "Male", "Developer", "Java");
        Employee employee2 = new Manager( 2,"Michaela", 15, "Female", "Manager",  1);

        employee.printEmployee();
        employee2.printEmployee();
    }
}
