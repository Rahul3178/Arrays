package practice;

import java.util.Arrays;

/*
* Moved all zeros to the end of array
* */
public class MovedAllZeros {
    public static void main(String[] args) {
            int [] array= {0,2,3,0,0,1,4,0,0};
       int [] res=allZerosMoved(array);
        System.out.println(Arrays.toString(res));

    }

    public static int[] allZerosMoved(int arr[])
    {
        int pos=0;

        for (int num:arr)
        {
            if (num!=0)
            {
                arr[pos++]=num;
            }
        }

        while (pos< arr.length)
        {
            arr[pos++]=0;
        }

        return arr;
    }
}
