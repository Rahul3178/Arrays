package practice;

public class SumOfNoUsingRecursion
{
    public static void main(String[] args) {
        int n =0;

        System.err.println(sumOFN(10));
    }

    public static int sumOFN(int n)
    {

        if (n==0)
        {
           return 0;
        }


       return n+ sumOFN(n-1);
    }
}
