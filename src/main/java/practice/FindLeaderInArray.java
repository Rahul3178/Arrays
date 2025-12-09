package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class FindLeaderInArray {
    public static void main(String[] args) {
        //the right most element is always a leader bcz there is no elements to its right
        // you need to check each elements and see if its bigger than all the elements that comes after it in the array.

        int array[]= {16,15,4,3,5,2};

        List<Integer> list = new ArrayList<>();
        int max=array[array.length-1];
        list.add(max);
        for (int pos=array.length-2;pos>=0;pos--)
        {
            if (array[pos]>max)
            {
                list.add(array[pos]);
                max=array[pos];
            }
        }


        System.err.println(list);

        // Stream api version using atomic
        AtomicInteger maxValue = new AtomicInteger(Integer.MIN_VALUE);

      int[] result=  IntStream.rangeClosed(0,array.length-1).map(index->array[array.length-1-index])
                .filter(val->{
                    if (val>maxValue.get())
                    {
                        maxValue.set(val);
                        return true;
                    }
                    return false;
        }).toArray();

        System.err.println(Arrays.toString(result));
    }
}
