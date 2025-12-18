package practice;

import java.util.Arrays;

public class BubbleSort
{
    public static void main(String[] args) {
        int[] arr = {4,2,7,1,2}; // Initialize an array

        for (int i=0; i< arr.length;i++)
        {
            boolean swapped=false;
            for (int j=0; j< arr.length-i-1;j++)
            {
                if (arr[j] > arr[j+1])
                {
                    int temp= arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swapped=true;
                }
            }
            if (!swapped) break;
        }

        for (int num : arr) {
            System.out.print(num + " ");  // Print sorted array
        }
    }
}
