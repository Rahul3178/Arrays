package deleted;

import java.util.Arrays;

public class InsertionSort
{
    public static void main(String[] args) {

        // take an element and put into right position

        int[] input = {4,2,7,1,2}; // Initialize an array

        for (int i=1;i<input.length;i++)
        {
            int key=input[i];
            int j=i-1;
            while (j>=0 && input[j]>key)
            {
                input[j+1]=input[j];
                j--;
            }
            input[j+1]=key;
        }

        System.err.println("Insertion sort\t" + Arrays.toString(input));
    }
}
