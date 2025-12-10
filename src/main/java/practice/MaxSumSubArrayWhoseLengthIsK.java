package practice;

public class MaxSumSubArrayWhoseLengthIsK {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        int sum =0;
        int maxSum=0;

        for (int i = 0; i < k; i++) {
            sum+= arr[i];
        }

        maxSum =sum;

        for (int i=k;i<arr.length;i++)
        {
            sum+=arr[i];
            sum-=arr[i-k];
            maxSum=Math.max(maxSum,sum);
        }

    }
}
