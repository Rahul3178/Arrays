package ScenarioBasedQuestions;

// EmployeeDto.java
public class EmployeeDto {
    private String name;
    private String department;
    private int age;
    private String gender;

    // Constructor
    public EmployeeDto(String name, String department, int age, String gender) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.gender = gender;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    // Optional: toString for easy printing
    @Override
    public String toString() {
        return "EmployeeDto{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}