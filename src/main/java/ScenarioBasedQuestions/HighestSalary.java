package ScenarioBasedQuestions;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Person{

 private    String name;
  private   int salarry;
  private String dept;

  Person(String name,int salarry, String dept)
  {
      this.name=name;
      this.salarry=salarry;
      this.dept=dept;
  }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalarry() {
        return salarry;
    }

    public void setSalarry(int salarry) {
        this.salarry = salarry;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Person{" +
               "name='" + name + '\'' +
               ", salarry=" + salarry +
               ", dept='" + dept + '\'' +
               '}';
    }
}
public class HighestSalary
{
    public static void main(String[] args) {


        List<Person> pList= Arrays.asList(new Person("Rahul",500,"HR")
        , new Person("Kumar",400,"HR")
        , new Person("Jangra",700,"HR")
        , new Person("San",400,"cs")
        , new Person("jan",300,"cs")
        , new Person("feb",400,"IT")
        , new Person("mar",450,"IT")

        );


//      Map<String,Person> result=  pList.stream().collect(Collectors.toMap(Person::getDept, Function.identity(), BinaryOperator.maxBy(Comparator.comparingInt(Person::getSalarry))));
//
//        result.entrySet().forEach(System.out::println);

      Map<String, Person>   res=   pList.stream().collect(Collectors.toMap(Person::getDept,Function.identity(),
                    BinaryOperator.maxBy(Comparator.comparingInt(Person::getSalarry))));

        res.entrySet().forEach(System.out::println);

        int limit=20;

   List<Integer> resu=
           IntStream.range(1,limit).filter(k->IntStream.range(2,(int) Math.sqrt(limit)).allMatch(div->k%div!=0)).boxed().collect(Collectors.toList());

        System.out.println(resu);

        int fib[]= new int[limit];
        fib[0]=0;
        fib[1]=1;

        IntStream.range(2,limit).forEach(i->fib[i]=fib[i-1]+fib[i-2]);
        IntStream.of(fib).forEach(System.out::println);

    }
}
