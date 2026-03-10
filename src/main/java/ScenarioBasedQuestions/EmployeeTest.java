package ScenarioBasedQuestions;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeTest
{
    public static void main(String[] args) {

        EmployeeDto employee1 = new EmployeeDto("SRK","ECE",31,"Male");
        EmployeeDto employee2 = new EmployeeDto("Salman","CS",44,"Male");
        EmployeeDto employee3 = new EmployeeDto("Katrina","ECE",21,"Female");
        EmployeeDto employee4 = new EmployeeDto("Kareena","CS",34,"Female");
        EmployeeDto employee5 = new EmployeeDto("Hrithik","EEE",30,"Male");
        EmployeeDto employee6 = new EmployeeDto("Aish","EEE",25,"Female");

        List<EmployeeDto> eList = Arrays.asList(employee1,employee2,employee3,employee4,employee5,employee6);

       /* Questions:
        1.Find the names of all Employees in the CS department, sorted by age in descending order
        2. Group Employees by department and count how many Employees are in each department
        3.Find the youngest female Employee.
        4. Create a map of department -> list of Employee names.
        5. Find the average age of Employees in each department.
        6. Get a list of unique departments Employees belong to - Pending
        7. Partition Employees into male and female groups, then list their names.
        8. Group employees by department, then within each department find the oldest employee
        9. Build a map of gender with average age of employees sorted by average age descending
        10. For each department, find the youngest employee, but instead of returning the employee object,
        return only their name in uppercase.
        11. Return a map where keys will be first letter of the name and value will the set of names starting with
        that letter, no solution provided, try on your own.
                Code link:  StreamsScenarios/StreamsOnEmployeeData.java at main · CodingLyf
        Fullstack/StreamsScenarios

        */


        eList.stream().filter(e-> Objects.equals(e.getDepartment(), "CS"))
             .sorted(Comparator.comparingInt(EmployeeDto::getAge).reversed())
             .map(EmployeeDto::getName).forEach(System.out::println);

        // Group employee by department
        eList.stream().collect(Collectors.groupingBy(EmployeeDto::getDepartment,Collectors.counting()))
             .entrySet()
             .forEach(System.out::println);

       EmployeeDto youngest=
               eList.stream().filter(e->e.getGender().equalsIgnoreCase("female")).min(Comparator.comparingInt(EmployeeDto::getAge)).get();

        System.out.println("Youngest female employee\t"+youngest);

//        Create a map of department -> list of Employee names.

        eList.stream().collect(Collectors.groupingBy(EmployeeDto::getDepartment,
                Collectors.mapping(EmployeeDto::getName,Collectors.toList()))).entrySet().forEach(System.out::println);


//        Find the average age of Employees in each department.

        eList.stream().collect(Collectors.groupingBy(EmployeeDto::getDepartment,
                Collectors.averagingInt(EmployeeDto::getAge))).entrySet().forEach(System.out::println);

//        7. Partition Employees into male and female groups, then list their names.

      Map<Boolean, List<String>> partitions=
              eList.stream().collect(Collectors.partitioningBy(e->e.getGender().equalsIgnoreCase("Male"),
                     Collectors.mapping(EmployeeDto::getName,Collectors.toList())));

      partitions.forEach((isMale,names)-> System.out.println((isMale?"Male":"Female")+names));

//       Group employees by department, then within each department find the oldest employee

      Map<String,String > group= eList.stream().collect(Collectors.groupingBy(EmployeeDto::getDepartment,
              Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(EmployeeDto::getAge)),
                      opt->opt.get().getName())));


      group.entrySet().forEach(System.out::println);

//        Build a map of gender with average age of employees sorted by average age descending

   Map<String ,Double> toMap= eList.stream().collect(Collectors.groupingBy(EmployeeDto::getGender,
                               Collectors.averagingInt(EmployeeDto::getAge)))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, e->Math.round(e.getValue()*100.0)/100.0,(a,b)->a,LinkedHashMap::new));
                   toMap.entrySet().forEach(System.out::println);

//For each department, find the youngest employee, but instead of returning the employee object,
//        return only their name in uppercase

        eList.stream().collect(Collectors.groupingBy(EmployeeDto::getDepartment,
                Collectors.collectingAndThen(Collectors.minBy(Comparator.comparingInt(EmployeeDto::getAge)),
                        op->op.get().getName()))).entrySet()
             .forEach(System.out::println);


        eList.stream().collect(Collectors.groupingBy(EmployeeDto::getDepartment,
                Collectors.collectingAndThen(Collectors.minBy(Comparator.comparingInt(EmployeeDto::getAge)),
                        opt->opt.get().getName()))).entrySet().forEach(System.out::println);

  /*      10. For each department, find the youngest employee, but instead of returning the employee object,
        return only their name in uppercase.*/

      Map<Character,Set<String >> out=
              eList.stream().collect(Collectors.groupingBy(e->e.getName().toUpperCase().charAt(0),
                Collectors.mapping(e->e.getName().toUpperCase(),
                Collectors.toSet())));

      out.entrySet().forEach(System.out::println);

    }

}
