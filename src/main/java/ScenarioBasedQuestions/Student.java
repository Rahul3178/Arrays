package ScenarioBasedQuestions;

public class Student {
    private String firstName;
    private String lastName;
    private String city;
    private double grade;
    private int age;
    private String department;

    // Constructor
    public Student(String firstName, String lastName, String city, double grade, int age, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.grade = grade;
        this.age = age;
        this.department = department;
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getCity() { return city; }
    public double getGrade() { return grade; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }

    // toString for easy printing
    @Override
    public String toString() {
        return firstName + " " + lastName + " | " + city + " | Grade: " + grade +
                " | Age: " + age + " | Dept: " + department;
    }
}
