package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindMajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        System.out.println("majority of element is \t"+isMajorityElementFound(nums));
            int length=nums.length;
        Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
              .entrySet().stream().filter(e->e.getValue()>length/2)
              .map(e->e.getKey()).forEach(e->System.out.println(e));

    }

    public static int isMajorityElementFound(int arr[])
    {
        HashMap<Integer,Integer> data = new HashMap<>();
        int length=arr.length;

        for (int num:arr)
        {
            data.put(num,data.getOrDefault(num,0)+1);
        }

        for (Map.Entry<Integer,Integer> entry:data.entrySet())
        {
            if (entry.getValue()>length/2){
                return entry.getKey();
            }
        }


       return -1;
    }

    public int isMajorityElementUsingStream(int arr[]){

        int length =arr.length;
             Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                   .entrySet().stream().filter(e->e.getValue()>length/2)
                   .map(e->e.getKey()).forEach(e->System.out.println(e));



        return -1;
    }
}
