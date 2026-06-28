package deleted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindCommonElementsInArray {
    public static void main(String[] args) {
        int[] arr1 = {7, 1, 9, 4, 6, 3};
        int[] arr2 = {10, 9, 5, 2, 4, 1};
        System.out.println(Arrays.toString(findCommon(arr1, arr2))); // Output: [1, 4, 9]
        System.out.println(Arrays.toString(findCommonStream(arr1, arr2)));
    }

    private static int[] findCommonStream(int[] arr1, int[] arr2) {

       Set<Integer> pass= Arrays.stream(arr2).boxed().collect(Collectors.toSet());

     return   Arrays.stream(arr1).boxed().filter(pass::contains).mapToInt(Integer::intValue).toArray();

    }

    private static int[] findCommon(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
       List<Integer> pass = new ArrayList<>();
        int i=0,j=0;

        while(i<arr1.length && j<arr2.length)
        {
            if (arr1[i]==arr2[j])
            {
                pass.add(arr1[i]);
                i++;
                j++;
            }else if(arr1[i]<arr2[j])
            {
                i++;
            }else if(arr1[i]>arr2[j])
            {
                j++;
            }
        }

        return pass.stream().mapToInt(Integer::intValue).toArray();
    }
}
