package streams;
public class Emp1 {
    private String name;
    private int salary;
    private String dept;

    public Emp1(String name, int salary, String dept) {
        super();
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp [name=" + name + ", salary=" + salary + ", dept=" + dept + "]";
    }

}