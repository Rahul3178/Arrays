package practice;

import java.util.Arrays;

public class RotateTheArrayByKthStep
{
    public static void main(String[] args) {
        int [] array= {1,2,3,4,5,6,7};
        int n= array.length;

        int k=3;

       /* reversed(array,0,n-1);
        System.err.println("reversed whole array \t"+ Arrays.toString(array));

        reversed(array,0,k-1); // bcz we start from zero
        System.err.println("reversed first half\t"+Arrays.toString(array));

        reversed(array,k,n-1);
        System.err.println("reversed end half \t"+Arrays.toString(array));*/

        opReversed(array,0,0);
        System.err.println("reversed\t"+Arrays.toString(array));

    }

    public static void reversed(int arr[], int start, int end)
    {
        while (start<end)
        {
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

    public static void opReversed(int arr[],int start, int end)
    {
        for (int i=0;i< arr.length/2;i++)
        {
            int temp=arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;

        }
    }
}
