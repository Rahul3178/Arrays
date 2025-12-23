package practice;

public class SumOfDigits
{
    public static void main(String[] args) {
        int number=12345;
        int sum=0;
        while (number>0)
        {
            sum += number%10;
            number/=10;

        }
        System.err.println("Sum \t"+sum);

        int n= String.valueOf(number).chars().map(c->c - '0').sum();
        System.err.println("Stream api sum \t"+n);


    }
}
