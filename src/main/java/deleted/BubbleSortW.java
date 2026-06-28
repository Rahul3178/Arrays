package deleted;

import java.util.Arrays;

public class BubbleSortW {
    public static void main(String[] args) {
        int[] arr={3,2,1,8,6,53,4,9,34};

        for (int i=0;i<arr.length;i++)
        {
            boolean swap=false;
            for (int j=0;j<arr.length-i-1;j++)
            {
                if (arr[j]>arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swap=true;
                }
            }
            if (!swap)
            {
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
