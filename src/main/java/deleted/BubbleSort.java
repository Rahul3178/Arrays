package deleted;

import java.util.Arrays;

public class BubbleSort
{
    public static void main(String[] args) {
        // bubble sort
        // pick one element comare woth the next element if next element is bigger than swap it unitil largest
        // element reach at the end in each pass

        int[] input = {4,2,7,1,2}; // Initialize an array

        for (int i=0; i<input.length;i++)
        {
            boolean swap=false;
            for (int j=0;j<input.length-i-1;j++)
            {
                if (input[j]>input[j+1])
                {
                    // swap
                    int temp= input[j];
                    input[j]=input[j+1];
                    input[j+1]=temp;
                    swap=true;
                }


            }
            if (!swap)
            {
                break;
            }
        }

        System.err.println(Arrays.toString(input));
    }
}
