package deleted;

/*
*The twist here vs. sum: a negative × negative = positive,
*  so you must track both the max and min product at every step.
 *
* */
public class MaxSubArrayProduct
{
    public static void main(String[] args) {
    int[] array={2, 3, -2, 4};  // 6 [2,3]
        int maxProduct=array[0];
        int currentMax=array[0];
        int currentMin=array[0];

        for (int i=1;i<array.length;i++)
        {
            // When multiplied by a negative, max becomes min and vice versa

            if (array[i]<0)
            {
                int temp=currentMax;
                currentMax=currentMin;
                currentMin=temp;
            }
            // Either start fresh or extend the subarray

            currentMax=Math.max(array[i],currentMax*array[i]);
            currentMin=Math.min(array[i],currentMin*array[i]);

            maxProduct=Math.max(maxProduct,currentMax);
        }

        System.out.println("Max product of sub array \t"+maxProduct);
    }
}
