package practice;

import java.util.ArrayList;
import java.util.List;

public class ArraySubsetRecursion
{
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5};
        generateSubset(arr,0,new ArrayList<>());
    }

    public static void generateSubset(int arr[],int index, List<Integer> current)
    {
        if (index==arr.length)
        {
            System.err.println(current);
            return;
        }

        generateSubset(arr,index+1,current); // exclude current
        current.add(arr[index]);  // include current element
        generateSubset(arr,index+1,current);

        // backtrace remove last element before return

        current.removeLast();
    }
}
