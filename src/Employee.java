public class Employee {

    private int id;
    private String name;
    private int age;
    private String gender;
    private String role;

    public Employee (int id, String name, int age, String gender, String role){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getGender(){
        return gender;
    }

    public String getRole(){
        return role;
    }

    public void printEmployee(){
        System.out.printf("name - %s\n", name);
    }
}
