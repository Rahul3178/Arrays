package deleted;
/*
*  Maximum profit by one buy and sell
* */
public class StocksBuyAndSell
{
    public static void main(String[] args) {


        int[] arr ={7,1,5,3,6,4};

        int minProfit=arr[0];
        int maxProfit=0;

        for (int i=0;i<arr.length;i++)
        {
            if (minProfit>arr[i])
            {
                minProfit=arr[i];
            }else{

                maxProfit=Math.max(maxProfit,arr[i]-minProfit);
            }


        }

        System.out.println("Maximum profit : "+maxProfit);


    }
}
