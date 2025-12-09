package practice;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MovedNegativeNumber
{
    public static void main(String[] args) {

        // using two pointer approach
        int[] array = {0, -2, 3, -1, 4, -5, 6};

        int left=0; // position to nest negative
        for (int right =0; right< array.length;right++)
        {
            if (array[right]<0)
            {
                int temp=array[left];
                array[left]=array[right];
                array[right]=temp;
                left++;

            }
        }
        System.err.println(Arrays.toString(array));

        // Using stream api

      int[] negative=  Arrays.stream(array).filter(x->x<0).toArray();
      int [] positive = Arrays.stream(array).filter(x->x>0).toArray();
     int[] mergerd=   IntStream.concat(Arrays.stream(negative),Arrays.stream(positive)).toArray();
        System.err.println("Using stream api"+Arrays.toString(mergerd));
    }
}
