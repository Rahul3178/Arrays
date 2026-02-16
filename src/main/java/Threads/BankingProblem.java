package Threads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class BankAccount{
    int balance =1000;
    private final Object lock = new Object();

    public void depositeMoney(int amount)
    {
        System.out.println(Thread.currentThread().getName()+"trying to deposite \t"+amount);
        synchronized (lock)
        {
            balance+=amount;
            System.out.println(Thread.currentThread().getName()+" new account balance is  \t"+this.getBalance());

        }
    }

    public void withdrawAmount(int amount)
    {
        System.out.println(Thread.currentThread().getName()+" trying to withdrow amount \t"+amount);
        synchronized (lock)
        {
            if (balance> amount)
            {
                balance-=amount;

                System.out.println(Thread.currentThread().getName()+"new balance is \t"+this.getBalance());
            }else {
                System.out.println(Thread.currentThread().getName()+"failed to withdraw amount"+amount);
            }
        }
    }

    public  int getBalance()
    {
        return this.balance;
    }
}
public class BankingProblem
{

    public static void main(String[] args) {

        BankAccount acc = new BankAccount();
        ExecutorService ex = Executors.newFixedThreadPool(1);

        ex.submit(() -> acc.depositeMoney(1000));
        ex.submit(() -> acc.depositeMoney(1000));
        ex.submit(() -> acc.withdrawAmount(1000));
        ex.submit(() -> acc.depositeMoney(1000));
    ex.shutdown();
        try {
            ex.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
