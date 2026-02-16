package deleted;

import java.util.Arrays;

public class MergeSort
{
    public static void main(String[] args) {
        int[] input={7,6,5,3,2,1,9,23};
        int length=input.length-1;
        mergerSort(input,0,length);

        System.out.println(Arrays.toString(input));
    }

    public static void mergerSort(int[] input,int start,int end)
    {
        if(start>=end)
        {
            return;
        }

        int mid = start + (end - start) / 2;

        mergerSort(input,start,mid);
        mergerSort(input,mid+1,end);
        swapSort(input,start,mid,end);
    }

    public static void swapSort(int[]arr, int low, int mid, int high)
    {
        int[] temp = new int[(high-low)+1];
        int left=low;
        int right=mid+1;
        int index=0;

        while (left<=mid && right<=high)
        {
            if(arr[left]<arr[right])
            {
                temp[index++]=arr[left];
                left++;
            }else{
                temp[index++]=arr[right];
                right++;
            }
        }

        while(left<=mid)
        {
            temp[index++]=arr[left];
            left++;
        }
        while(right<=high)
        {
            temp[index++]=arr[right];
            right++;
        }

        for(int i=low;i<=high;i++)
        {
            arr[i]=temp[i-low];
        }

    }
}
