package deleted;

import java.util.Arrays;

public class SubArraySum
{
    public static void main(String[] args) {
        int [] array ={1,2,3,7,5};
        int target =12;

        int start=0;
        int end=0;
        int currentSum=0;
        while (end<array.length)
        {

            currentSum=currentSum+array[end];

            if (currentSum > target && start<end)
            {
                currentSum=currentSum-array[start];
                start++;
            }

            if (currentSum== target)
            {
                break;
            }
            end++;
        }


        System.out.println(start+" \t"+end);
    }

}
