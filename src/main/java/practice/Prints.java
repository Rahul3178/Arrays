package practice;

public class Prints
{
    public static void main(String[] args) {

        prints(1);


    }

    public static void prints(int n)
    {
        if (n>100)
        {
            return;
        }
        System.out.println(n);
        prints(n+1);

    }
}
