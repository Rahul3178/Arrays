package deleted;

public class BinarySearch
{
    public static void main(String[] args) {
        int[] array={2,3,4,5,6,7,8,9,20,34,35,56};
            int target=9;
        System.out.println(binary(array,target));

    }

    public static int binary(int[] arr, int target)
    {
        int low=0, high=arr.length-1;
        while(low<=high)
        {
        int mid=high-(high-low)/2;

        if(arr[mid]==target)
        {
            return mid;
        }else if (arr[mid]<target){
            low=mid+1;
        }else {
            high=mid-1;
        }

        }

        return -1;
    }
}
