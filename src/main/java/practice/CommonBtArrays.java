package practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CommonBtArrays
{
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7};

        Set<Integer> common = new HashSet<>();

        // first approach O(n2)

        for (int i:arr1)
        {
            for (int j : arr2)
            {
                if (i == j)
                {
                    common.add(i);
                }

            }
        }

        System.err.println("Using two pointer approach");
        common.forEach(System.err::print);

        // 2nd approach
        Set<Integer> com = new HashSet<>();
        for (int i:arr1)
        {
            com.add(i);
        }

        Arrays.stream(arr2).filter(com::contains).forEach(System.err::println);
    }
}
