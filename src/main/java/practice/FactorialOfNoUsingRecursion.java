package practice;

import java.util.stream.IntStream;

public class FactorialOfNoUsingRecursion
{
    public static void main(String[] args) {
        int number=5;
        System.err.println("Factorial of Number: "+number+"\t"+factorial(number));

       int reduce= IntStream.rangeClosed(1, 5)   // stream of numbers from 1 to n
                 .reduce(1, (a, b) -> a * b);

        System.err.println(reduce);
    }

    public static int factorial(int n)
    {
        if (n==0 || n==1)
        {
            return 1;
        }
        return n*factorial(n-1);
    }
}
