package ScenarioBasedQuestions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DemoTest {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Rahul", "Sharma", "Hyderabad", 8.38, 19, "Civil"),
                new Student("Amit", "Verma", "Delhi", 8.4, 21, "IT"),
                new Student("Suresh", "Reddy", "Chennai", 7.5, 20, "Civil"),
                new Student("Kiran", "Patel", "Mumbai", 9.1, 20, "IT"),
                new Student("Arjun", "Naidu", "Bengaluru", 7.83, 20, "Civil")
        );

       /* Questions:
        1. Find students from Hyderabad with a grade greater than 8.0
        2. Find the student with the highest grade
        3. Count the number of students in each department
        4. Find the average grade per department
        5. List students sorted by age and then by grade
        6. Create a comma-separated list of student names
        7. Check if all students are above 18
        8. Find the department with the most students
        9. Divide students into those who have grades above 8.0 and below
        10. Find the student with the longest full name*/


        students.stream()
                .filter(s -> s.getCity()
                              .equals("Hyderabad") && s.getGrade() > 8.0)
                .forEach(System.out::println);

        for (Student s : students) {
            if (s.getCity()
                 .equals("Hyderabad") && s.getGrade() > 8.0) {
                System.out.println(s);
            }
        }

        // student with highest grade

        students.stream()
                .max(Comparator.comparingDouble(Student::getGrade))
                .ifPresent(System.out::println);

        // count the number of each student in each department

        students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()))
                .forEach((key, value) -> System.out.println(key + "\t" + value));


//        5. List students sorted by age and then by grade
        students.stream().sorted(Comparator.comparingInt(Student::getAge).thenComparing(Student::getGrade)).forEach(System.out::println);
        // 6. Create a comma-separated list of student names

      String st=  students.stream().map(Student::getFirstName).collect(Collectors.joining(","));
        System.out.println("Student name list\t"+st);

//        7. Check if all students are above 18

       boolean ageCheck= students.stream().allMatch(s->s.getAge()>18);

        System.out.println("All the student are above 18 \t"+ageCheck);

        // 8. Find the department with the most students

      String val=  students.stream().collect(Collectors.groupingBy(Student::getDepartment,Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

        System.out.println(val);

//        9. Divide students into those who have grades above 8.0 and below
      Map<Boolean,List<Student>>  result= students.stream().collect(Collectors.partitioningBy(s->s.getGrade()>8.0));
        System.out.println("------------------Grade above-------------------------");
      result.get(true).forEach(System.out::println);
        System.out.println("------------------Grade below-------------------------");
        result.get(false).forEach(System.out::println);
//        10. Find the student with the longest full name
        students.stream().max(Comparator.comparing(Student::getFirstName)).ifPresent(System.out::println);
    }
}
