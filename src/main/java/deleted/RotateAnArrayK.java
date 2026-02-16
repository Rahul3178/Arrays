package deleted;

import java.util.Arrays;

public class RotateAnArrayK
{
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6};
        int k=2;
        int n =arr.length;

        rightRotate(arr,k,n);

        System.out.println(Arrays.toString(arr));

    }

    private static void leftRotate(int[] arr,int k, int length)
    {
        roatate(arr,0,k-1);
        roatate(arr,k,length-1);
        roatate(arr,0,length-1);
    }

    public static void rightRotate(int[] arr,int k, int lenght)
    {
        leftRotate(arr,k,lenght-k);
    }

    private static void roatate(int[] arr, int start, int end)
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
}
