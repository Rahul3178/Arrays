package deleted;

import java.util.Arrays;

public class InsertSort
{
    public static void main(String[] args) {
        int[] arr={3,2,1,8,6,53,4,9,34};

        for (int i = 1; i < arr.length; i++) {
            int key=arr[i];
            int j=i-1;
            while (j>=0 && arr[j]>key)
            {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }

        System.out.println("insertion sort \t" + Arrays.toString(arr));
    }
}
