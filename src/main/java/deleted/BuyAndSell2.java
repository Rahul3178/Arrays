package deleted;

public class BuyAndSell2
{
    public static void main(String[] args) {
        int[] array={7,1,5,3,6,4};

        int maxProfit=0;
        for (int i=1;i<array.length;i++)
        {
            if (array[i]-array[i-1]>0)
            {
                maxProfit+=array[i]-array[i-1];
            }
        }

        System.out.println("Maximum profit is :"+maxProfit);
    }
}
