package streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice
{
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Orange", "Apple", "Banana", "Orange", "Mango", "Apap");

        // remove duplicate

        new HashSet<>(list).forEach(System.out::println);

        // largest string

        list.stream().max(Comparator.comparingInt(String::length)).ifPresent(System.out::println);

        // find a number starting with one

        List<Integer> num = Arrays.asList(1, 23, 13, 34, 11, 29);

        num.stream().map(String::valueOf).filter(i->i.startsWith("1")).map(Integer::valueOf).forEach(System.out::println);


        // Join two streams
        List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> l2 = Arrays.asList(5, 2, 4, 6, 7, 8, 9);

        Stream.concat(l1.stream(),l2.stream()).distinct().sorted().forEach(System.out::println);

        // number is prime of not
        List<Integer> check = Arrays.asList(4, 6, 9, 11, 15, 19, 4, 3, 6, 9);

        check.stream().filter(Practice::isPrime).forEach(System.err::println);

        // find first 4 prime numbers
        int limit=4;
      List<Integer> result= IntStream.rangeClosed(1,40)
                .filter(i->IntStream.rangeClosed(2,(int) Math.sqrt(limit))
                                    .allMatch(div->i % div !=0)).boxed().toList();

        System.err.println(result);

        // Given a list of stream, Find out those string which is started with a number
        List<String> word = Arrays.asList("1apple", "Banana", "Cherry", "2Mango");

      List<String> find=  word.stream().filter(str->!str.isBlank() && Character.isDigit(str.charAt(0))).toList();

        System.err.println(find);

        // Check given string is palindrome or not using streams
        String name = "AMA";

       Boolean str=
               IntStream.rangeClosed(0,name.length()/2).allMatch(i->name.charAt(i) == name.charAt(name.length()-i-1));

        System.err.println("Palindrom is "+str);

        int[] arrn = {12, 3, 5, 7, 19, 1, 8};

        int n = 3;


       int[] all=
               Arrays.stream(arrn).boxed().sorted(Comparator.reverseOrder()).limit(n).mapToInt(Integer::intValue).toArray();


        System.err.println(Arrays.toString(all));

        // find the sum of two numbers in given list

        int sum=Arrays.stream(arrn).sum();
        System.err.println("sum"+sum);

        Arrays.stream(arrn).min();
     int sum2=   l1.stream().mapToInt(Integer::intValue).sum();
  int min=   l1.stream().mapToInt(Integer::intValue).min().getAsInt();
  int max=   l1.stream().mapToInt(Integer::intValue).max().getAsInt();

        System.err.println("Sum\t"+sum2+" Min\t"+min+" Max\t"+max);


        // Given a string , find the first non repeated character in it using stream functions?

        String wordo = "swiss";

        wordo.chars().mapToObj(c-> (char)c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,
                Collectors.counting())).entrySet().stream()
             .filter(e->e.getValue()>1).map(Map.Entry::getKey).findFirst()
             .ifPresent(System.err::println);


        wordo.chars().mapToObj(c-> (char)c).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,
                Collectors.counting())).entrySet().stream()
             .filter(e->e.getValue()==1).map(Map.Entry::getKey).findFirst().ifPresent(System.err::println);


        List<Emp1> employee2 = Arrays.asList(new Emp1("Rahul", 3400, "IT"), new Emp1("Kumar", 3200, "ADM"),
                new Emp1("Jangra", 2000, "DH"), new Emp1("Infosys", 2300, "CIS"), new Emp1("Rudra", 4300, "CIS"),
                new Emp1("Yuvi", 2300, "CIS"));


        employee2.stream().collect(Collectors.groupingBy(Emp1::getDept,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Emp1::getSalary)),
                        Optional::get))).entrySet().stream()
                 .max(Comparator.comparingInt(e->e.getValue().getSalary())).ifPresent(System.err::println);


        // How to group by employee age using stream

        List<Employee> employee = new ArrayList<>();
        employee.add(new Employee("Amit", 101, 22, 100000, new Department("AMD", 1, 101)));
        employee.add(new Employee("Rahul", 102, 33, 88000, new Department("CMD", 2, 102)));
        employee.add(new Employee("Btech", 103, 55, 93000, new Department("IVS", 3, 103)));
        employee.add(new Employee("Parth", 104, 38, 957000, new Department("CIS", 4, 104)));
        employee.add(new Employee("Rudra", 105, 40, 70000, new Department("IT", 5, 105)));
        employee.add(new Employee("Yuvi", 105, 40, 89000, new Department("CCD", 6, 106)));
        employee.add(new Employee("Nano", 107, 55, 55500, new Department("FEDEX", 7, 107)));
        employee.add(new Employee("Fano", 108, 22, 40440, new Department("HTAMD", 8, 108)));

        employee.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .forEach(System.err::println);


        // get employee name by department

        employee.stream().collect(Collectors.groupingBy(e->e.getDepartment().getName(),
                Collectors.mapping(Employee::getName,Collectors.toList()))).entrySet().forEach(System.err::println);

        // sort multiple fields using streams

    Map<Integer,Employee> na=
            employee.stream().sorted(Comparator.comparingInt(Employee::getAge).thenComparing(Employee::getSalary)).collect(Collectors.toMap(Employee::getEmpId,Function.identity(),(e1,e2)->e1,LinkedHashMap::new));

    na.entrySet().forEach(System.err::println);


        // Stream.of Nullable
        List<String> names = Arrays.asList("Rahul", "Kumar", null, "jangra", "hello", null, "yuvan", "rudra");

        names.stream().flatMap(Stream::ofNullable).forEach(System.err::println);

        // sorted based on value in reverse order

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("anil", 1000);
        map2.put("bhavna", 1300);
        map2.put("micael", 1500);
        map2.put("tom", 1600);//output
        map2.put("ankit", 1200);
        map2.put("daniel", 1700);
        map2.put("james", 1400);

      List<Map.Entry<String,Integer>> ls=
              map2.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).toList();

      ls.forEach(System.err::println);


        // amximum salary by department

        employee.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)),
                Optional::get))).entrySet().stream().max(Comparator.comparingInt(e->e.getValue().getSalary()))
                .map(e->e.getKey().getName()).ifPresent(System.err::println);


        List<Rk> r = Arrays.asList(
                new Rk("Alice", "25", Arrays.asList(new Address("101"))),
                new Rk("Bob", "30", Arrays.asList(new Address("102"))),
                new Rk("Charlie", "28", Arrays.asList(new Address("103"))),
                new Rk("David", "35", Arrays.asList(new Address("104"))),
                new Rk("Eve", "22", Arrays.asList(new Address("105"))),
                new Rk("Frank", "27", Arrays.asList(new Address("106"), new Address("107"), new Address("108"))),
                new Rk("Grace", "31", Arrays.asList(new Address("109"), new Address("110"), new Address("111"))),
                new Rk("Hannah", "29", Arrays.asList(new Address("112"), new Address("113"), new Address("114")))
        );


        r.stream().flatMap(e->e.address.stream()).toList();

        Map<String, List<Address>> empAddressMap =
                r.stream().collect(Collectors.toMap(Rk::getName, Rk::getAddress,
                        (a, b) -> { List<Address> merged = new ArrayList<>(a); merged.addAll(b); return merged; },
                        LinkedHashMap::new));

        empAddressMap.entrySet().forEach(System.err::println);


        // duplicate with its count
        List<Integer> lst = Arrays.asList(11, 23, 34, 45, 35, 99, 99, 56, 89, 34);

      List<Integer> freq=  lst.stream().filter(i->Collections.frequency(lst,i)>1).toList();
        System.err.println(freq);


        // fibonachi
        int lim=10;
        int a[] = new int[lim];
        a[0] =0;
        a[1] =1;

        IntStream.range(2,lim).forEach(i->a[i]=a[i-1]+a[i-2]);
        IntStream.of(a).forEach(System.err::println);

    }

    public static boolean isPrime(int num)
    {
        if (num<0)
        {
            return false;
        }

      return   IntStream.rangeClosed(2,(int) Math.sqrt(num)).noneMatch(s->num%s==0);
    }
}
