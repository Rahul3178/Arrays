package deleted;

import java.util.Arrays;

public class MergeSortW
{
    public static void main(String[] args) {
        int[] arr={3,2,1,8,6,53,4,9,34};

        mergeSort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] array,int low, int high)
    {
        if (low == high)
        {
            return;
        }
        int mid =(low+high)/2;
        mergeSort(array,low,mid);
        mergeSort(array,mid+1,high);

        mergerSortFinal(array,low,mid,high);
    }

    public static void mergerSortFinal(int[] array, int low, int mid, int high)
    {
        int[] temp= new int[(high-low)+1];
        int left=low;
        int right=mid+1;
        int index=0;

        while (left<=mid && right<=high)
        {
            if (array[left]<array[right])
            {
                temp[index++]=array[left];
                left++;
            }else{
                temp[index++]=array[right];
                right++;
            }

            while(left<=mid)
            {
                temp[index++]=array[left];
                left++;
            }
            while (right<=high)
            {
                temp[index++]=array[right];
                right++;
            }

            for (int i=low; i<=high;i++)
            {
                array[i]=temp[i-low];
            }
        }

    }
}
