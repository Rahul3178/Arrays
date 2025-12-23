package streams;

import ScenarioBasedQuestions.EmployeeDto;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InterviewDay1
{
    public static void main(String[] args) {
        // remove duplicate without distict()

        List<Integer> ls = Arrays.asList(1, 2, 3, 4, 3, 2, 1);
        Set<Integer> rem = new
                HashSet<>();
        List<Integer> noDup = ls.stream()
                                .filter(rem::add)
                                .toList();

        rem.clear();
        List<Integer> dup = ls.stream()
                              .filter(s -> !rem.add(s))
                              .toList();

        noDup.forEach(System.err::println);
        System.out.println("-----------------------------------");
        dup.forEach(System.err::print);

        System.err.println("Reverse ");
        List<Integer> lst = Arrays.asList(11, 22, 33, 44, 55);
        lst.stream()
           .sorted(Collections.reverseOrder())
           .forEach(System.err::println);

        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL",
                "C");

        listOfStrings.stream()
                     .sorted(Comparator.comparingInt(String::length)
                                       .reversed())
                     .forEach(System.err::println);

//        How do you sort the given list of decimals in reverse order?
        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
        decimalList
                .stream()
                .sorted(Comparator.comparingDouble(Double::doubleValue))
                .forEach(System.err::println);

        // find the maximum number in the list

        double maxNumber = decimalList.stream()
                                      .max(Comparator.naturalOrder())
                                      .orElse(0.0d);

        System.err.println("Maximum number form the list \t" + maxNumber);


        listOfStrings.stream()
                     .max(Comparator.comparingInt(String::length))
                     .ifPresent(System.err::println);

        // find number is starting with one
        List<Integer> numbers = Arrays.asList(10, 12, 20, null, 19, 30);

        numbers.stream()
               .filter(s -> String.valueOf(s)
                                  .startsWith("1"))
               .forEach(System.err::println);

        // top three element
        List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95,
                14, 56, 87);

        listOfIntegers.stream()
                      .sorted(Comparator.reverseOrder())
                      .limit(3)
                      .forEach(System.err::println);

        // Strings are anagrams

        String s1 = "RaceCar";
        String s2 = "CarRace";

        String first = Stream.of(s1.split(""))
                             .sorted()
                             .collect(Collectors.joining());
        String second = Stream.of(s2.split(""))
                              .sorted()
                              .collect(Collectors.joining());


        if (first.equals(second)) {
            System.out.println("strings are anagrams");
        } else {
            System.out.println("strings are not anagrams");
        }

        System.out.println("Strings are anagrams \t" + isAnagram(s1, s2));

//        Sum of all Numbers in a digit

        int i = 15623;

        int sum = Arrays.stream(String.valueOf(i)
                                      .split(""))
                        .mapToInt(Integer::parseInt)
                        .sum();

        System.out.println("Sum of all integer\t" + sum);
// Reverse each word of a String
        String str = "Java Concept Of The Day";

        String reversed = Arrays.stream(str.split(" "))
                                .map(s -> new StringBuilder(s).reverse())
                                .collect(Collectors.joining(
                                        " "));

        System.out.println("String reversed using string builder \t" + reversed);


        // count the number of occurrence of given string
        List<String> strings = Arrays.asList("java scala ruby", "java react spring java");
        String word = "java";
        long count = strings.stream()
                            .flatMap(s -> Arrays.stream(s.split("\\s+")))
                            .filter(w -> w.equals(word))
                            .count();
        System.out.println("Count the given word from the string \t" + count);

//        Convert the list of sentences into unique words.

        List<String> sentences = List.of("java is cool", "cool code in java");

        Set<String> unique = sentences.stream()
                                      .flatMap(s -> Arrays.stream(s.split("\\s+")))
                                      .collect(Collectors.toSet());

        unique.forEach(System.err::println);
        List<List<Integer>> nums = List.of(List.of(1, 2), List.of(3, 4));
        List<Integer> nl = nums.stream()
                               .flatMap(Collection::stream)
                               .toList();
        nl.forEach(System.out::println);

//        find the longest words into the string list

        List<String> words = Arrays.asList("apple", "banana", "orange",
                "pineapple", "blueberry");

       long max= words.stream().max(Comparator.comparingInt(String::length)).get().length();

       words.stream().filter(s->s.length()==max).forEach(System.out::println);


       // max number using reduce

        List<Integer> numbs = Arrays.asList(7, 2, 10, 4);

        int maxr= numbs.stream().reduce(Integer.MIN_VALUE,(a,b)->a>b?a:b);
       int minr= numbs.stream().reduce(Integer.MAX_VALUE,(a,b)->a<b?a:b);

        System.out.println("Maximum  and min number using reduce\t"+maxr+" "+minr);

        List<String> wordss = Arrays.asList("cat", "elephant", "dog", "tiger");

       String wo= wordss.stream().reduce("",(a,b)->a.length()>b.length()?a:b);

        System.out.println("words based on length \t"+wo);

        // longest common substring

        List<String> stri= Arrays.asList("flower", "flow", "flight");
        islongestCommonSubstring(stri);

        //Max Product in a given array
        int[] array = { 1, 4, 9, 6, 2, 7, 8 };

        int maxProduct=
                IntStream.range(0,array.length).map(k->IntStream.range(k+1,array.length).map(j->array[k]*array[j]).max().orElse(0)).max().orElse(0);

        System.out.println("Max product of array\t"+maxProduct);

//        First non-repeating character in a String

        String input = "aabbcdeffg";

        input.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(e->e.getValue()==1).map(Map.Entry::getKey).findFirst().ifPresent(System.out::println);
//  Frequency or count of each word
        String sentence = "Java is fun and java is powerful";
        Arrays.stream(sentence.split("\\s+")).map(String::toUpperCase).collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting())).entrySet().stream().forEach(entry-> System.out.println(entry.getKey()+"\t"+entry.getValue()));



    }

    public static boolean isAnagram(String s1, String s2)
    {
        char[] first=s1.toCharArray();
        char[] second=s2.toCharArray();

        Arrays.sort(first);
        Arrays.sort(second);

        return Arrays.equals(first, second);
    }

    public static void islongestCommonSubstring(List<String> str)
    {

     String found=  str.stream().reduce((s1,s2)->{
            int length= Math.min(s1.length(),s2.length());
            int i=0;

            while(i<length && s1.charAt(i)==s2.charAt(i)){
                i++;
            }
            return s1.substring(0,i);
        }).orElse("No Sub string ");

        System.out.println("Sub String \t"+found);
    }

}
