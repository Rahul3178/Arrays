package deleted;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortAndCount {

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 5, 2, 8, 3, 3, 8};

//         in java 8

        Map<Integer,Long> result=
                Arrays.stream(arr).sorted().boxed().collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()));


        result.entrySet().forEach(System.out::println);
    }
}
