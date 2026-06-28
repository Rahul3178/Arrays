package practice;

import java.util.*;
import java.util.stream.Collectors;

public class SortMapByValue
{
    public static void main(String[] args) {
        HashMap<String,Integer> scores= new HashMap<>();
            scores.put("Mahesh",45);
            scores.put("NTR",30);
            scores.put("Chiru",75);
            scores.put("Balu",60);

       LinkedHashMap<String,Integer> result=  scores.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                          (e1,e2)->e1,
                            LinkedHashMap::new

                  ));

        System.err.println(result);
LinkedHashMap<String, Integer> rs =
                      scores.entrySet().stream()
                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                            .collect(Collectors.toMap(
                                    Map.Entry::getKey,
                                    Map.Entry::getValue,
                                    (o, n) -> o, LinkedHashMap::new ));


    rs.entrySet().forEach(System.out::println);


    int num=1234;

    int[] array={1,2,3,4,5,6,8};
    int sum=Arrays.stream(String.valueOf(num).split("")).mapToInt(Integer::parseInt).sum();

   int rnd = Arrays.stream(array).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();

        System.out.println(rnd);



        System.out.println(sum);
    }


}
