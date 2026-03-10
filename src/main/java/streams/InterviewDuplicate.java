package streams;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterviewDuplicate
{
    public static void main(String[] args) {
        // remove duplicate without distict()

        List<Integer> ls = Arrays.asList(1, 2, 3, 4, 3, 2, 1);

        ls.stream().distinct().forEach(System.out::println);

        new HashSet<>(ls).forEach(System.out::println);
        System.out.println("-----------------------------------");
        Set<Integer> lm= new HashSet<>();

        //duplicate
        ls.stream().filter(Predicate.not(lm::add)).forEach(System.out::println);

//        System.err.println("Reverse ");
//        System.err.println("Reverse ");
        List<Integer> lst = Arrays.asList(11, 22, 33, 44, 55);

        lst.stream().sorted(Comparator.reverseOrder()).forEach(s-> System.out.println("reverser order"+s));

        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL",
                "C");

        listOfStrings.stream().sorted(Comparator.comparingInt(String::length).reversed()).forEach(System.out::print);

        System.out.println("Max length of string");

        listOfStrings.stream().max(Comparator.comparingInt(String::length)).ifPresent(System.out::println);

        System.out.println("Min length");

        listOfStrings.stream().min(Comparator.comparingInt(String::length)).ifPresent(System.out::println);

//        How do you sort the given list of decimals in reverse order?
        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);


        decimalList.stream().sorted(Comparator.comparingDouble(Double::doubleValue).reversed()).forEach(System.out::println);

        // find number is starting with one
        List<Integer> numbers = Arrays.asList(10, 12, 20, null, 19, 30);

        numbers.stream().filter(s->String.valueOf(s).startsWith("1")).forEach(System.out::println);

        // top three element
        List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95,
                14, 56, 87);

        listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);

        // Strings are anagrams

        String s1 = "RaceCar";
        String s2 = "CarRace";

        String one= Arrays.stream(s1.split("")).sorted().collect(Collectors.joining());

        String two = Arrays.stream(s2.split("")).sorted().collect(Collectors.joining());

        if(one.equals(two))
        {
            System.out.println("String are anagram ");
        }else{
            System.out.println("String are not anagrams");
        }

        // sum of all numbers
        int i = 15623;

      int sum=  Arrays.stream(String.valueOf(i).split("")).mapToInt(Integer::parseInt).sum();
        System.out.println(sum);

        String str = "Java Concept Of The Day";

        String reversed = Arrays.stream(str.split(" "))
                                .map(s -> new StringBuilder(s).reverse())
                                .collect(Collectors.joining(
                                        " "));


        System.out.println("String reversed using string builder \t" + reversed);
     String wordrev=   Arrays.stream(str.split(" ")).sorted(Comparator.reverseOrder()).collect(Collectors.joining());

        System.out.println(wordrev);


        // count the number of occurrence of given string
        List<String> strings = Arrays.asList("java scala ruby", "java react spring java");
        String word = "java";

      long tot=  strings.stream()
                        .flatMap(st->Arrays.stream(st.split("\\s+")))
                        .filter(w->w.equals(word)).count();
        System.out.println(tot);
        List<List<Integer>> nums = List.of(List.of(1, 2), List.of(3, 4));

     List<Integer> uniq=   nums.stream().flatMap(Collection::stream).toList();
        System.out.println(uniq);

        //        find the longest words into the string list

        List<String> words = Arrays.asList("apple", "banana", "orange",
                "pineapple", "blueberry");

      String oy=  words.stream().max(Comparator.comparingInt(String::length)).get();
        System.out.println("longest word"+oy);


//        First non-repeating character in a String

        String input = "aabbcdeffg";

        input.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet()
                .stream().filter(e->e.getValue()==1).map(Map.Entry::getKey).findFirst().ifPresent(System.out::println);


        // longest common substring

        List<String> stri= Arrays.asList("flower", "flow", "flight");
//        islongestCommonSubstring(stri);

     String rt=   stri.stream().reduce((s11,s22)->{
            int minLength=Math.min(s11.length(),s22.length());
            int x=0;
            while(x<minLength && s11.charAt(x)== s22.charAt(x))
            {
                x++;
            }

            return  s11.substring(0,x);
        }).orElse("No common string");
        System.out.println(rt);

        List<Integer> numbs = Arrays.asList(7, 2, 10, 4);

        int mxNum= numbs.stream().reduce(Integer.MIN_VALUE,(a,b)->a>b?a:b);
        int min = numbs.stream().reduce(Integer.MAX_VALUE,(a,b)->a>b?b:a);

        System.out.println("Max number is :"+mxNum+"\t"+"Minumn number is :"+min);

        List<String> wordss = Arrays.asList("cat", "elephant", "dog", "tiger");

   String big=     wordss.stream().reduce("",(a,b)->a.length()>b.length()?a:b);

        System.out.println("Big is \t"+big);
    }
}
