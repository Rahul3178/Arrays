package practice;


public class MaximunmSubArrayProblem
{
    public static void main(String[] args) {
        int[] arr = { 2, 3, -2, 4 };
        System.err.println("Max Product of Subarray: " + findMaxProductOfSubarray(arr));
        // Expected Output: 6 → subarray [2,3]
    }

    private static int findMaxProductOfSubarray(int[] arr) {
        int result= arr[0];
        int maxProd=arr[0];
        int minProd=arr[0];

        for (int i=1;i<arr.length;i++)
        {
            int num=arr[i];
            if (num<0)
            {
                // if number is negative swap
                int temp=maxProd;
                maxProd=minProd;
                minProd=temp;
            }

            maxProd = Math.max(num,num*maxProd);
            minProd =Math.min(num,num*minProd);

            result =Math.max(result,maxProd);
        }
        return result;
    }
}
