public class Developer extends Employee {

    private String programming_language;

    public Developer(int id, String name, int age, String gender, String role, String programming_language){
        super(id, name, age, gender, role);
        this.programming_language = programming_language;
    }

    public void printEmployee(){
        System.out.printf("Id: %d \n" +
                        "Name: %s \n" +
                        "Age: %d \n" +
                        "Gender: %s \n" +
                        "Role: %s \n" +
                        "Programming Language: %s \n",
                getId(),
                getName(),
                getAge(),
                getGender(),
                getRole(),
                programming_language);
    }
}
