package practice;

import java.util.HashMap;

public class FindTHeArrayWithGivenSum {
    public static void main(String[] args) {
        int [] array ={1,2,3,7,5};
        int target =12;
        findSubArrayWithGivenSum(array,target);
        HashMap<Integer,Integer> data = new HashMap<>();

        for(int i=0;i<array.length;i++)
        {
            int compliment = target-array[i];

            if (data.containsKey(compliment))
            {
                System.out.println("Indices found " + data.get(compliment) + " 2nd number " + i);
                break;
            }

            data.put(array[i],i);


        }

    }

    private static void findSubArrayWithGivenSum(int[] arr, int targetSum) {
        int start=0, end=0, currentSum=0;

        // slide the window from left to right
        while (end< arr.length)
        {
            currentSum+=arr[end];


            // Shrink window from the left if sum exceeds target
            while (currentSum>targetSum && start<end)
            {
                currentSum -=arr[start];
                start++;

            }

            if (currentSum==targetSum)
            {
                break;
            }

            end++;
        }


        // Print indexes of subarray
        System.err.println("Indexes of subarray; start: " + start + " end: " + end);

    }
}
