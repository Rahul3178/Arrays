package deleted;

import java.util.Arrays;

public class SelectionSort
{
    public static void main(String[] args) {

        // selection sort pick one element and replace with minimum element
        // in each pass smallest number came to first

        int[] input = {4,2,7,1,2}; // Initialize an array


        for (int i=0; i<input.length-1;i++)
        {
            int minIndex=i;
            for (int j=i+1; j<input.length;j++)
            {
                if(input[j]<input[minIndex])
                {
                    minIndex=j;
                }
            }

            // now swap

            int temp=input[minIndex];
            input[minIndex]=input[i];
            input[i]=temp;

        }

        System.err.println("Insertion Sort\t" + Arrays.toString(input));
    }
}
