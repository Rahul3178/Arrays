package deleted;

import java.util.Arrays;

public class SelectionSort
{
    public static void main(String[] args) {
        int[] arr={3,2,1,8,6,53,4,9,34};

        for (int i = 0; i < arr.length-1; i++) {
            int minIndex=i;
            for (int j=i+1;j< arr.length;j++)
            {
                if (arr[minIndex]>arr[j])
                {
                    minIndex=j;
                }
            }

            int temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
