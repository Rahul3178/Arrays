package practice;

import java.util.Arrays;

public class InsertionSort
{
    public static void main(String[] args) {
        int[] a ={5,4,2,3,9,7,8};

        for (int i=1;i<a.length;i++)
        {
            int key=a[i];
            int j=i-1;

            while (j>=0 && a[j]>key)
            {
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=key;
        }

        System.err.println("Insertion Sort \t"+ Arrays.toString(a));
    }
}
