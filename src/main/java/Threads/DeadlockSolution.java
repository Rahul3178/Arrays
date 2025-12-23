package Threads;

import java.util.concurrent.locks.ReentrantLock;

class SharedResources{

    //locking

   final ReentrantLock reentrantLock = new ReentrantLock();

    public synchronized void test(SharedResources resource)
    {
        boolean acquire =false;

        System.out.println("Method test triggered"+Thread.currentThread().getName());
        try {
            acquire = reentrantLock.tryLock();
            if (acquire)
            {
                System.out.println("Triggered 2nd method from method 1"+Thread.currentThread().getName());
                Thread.sleep(5000);
            }else {
                System.out.println(Thread.currentThread().getName()+"Lock is not acquired");
            }
            if (resource.reentrantLock.tryLock())
            {
                resource.test2();
            }else {
                System.out.println(Thread.currentThread().getName()+"Not able to acquire lock");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            if (acquire) reentrantLock.unlock();
        }

    }

    public synchronized void test2()
    {
        boolean acquire=false;
        try
        {
            acquire =reentrantLock.tryLock();
            if (acquire)
            {
               Thread.sleep(3000);
               System.out.println("Test 2 triggered"+Thread.currentThread().getName());
            }else {
                System.out.println(Thread.currentThread().getName()+"Thread not able to acquire lock");
            }
        }catch (InterruptedException ex)
        {
            ex.getMessage();
        }finally {
            if(acquire) reentrantLock.unlock();
        }

    }
}

public class DeadlockSolution {

    public static void main(String[] args) throws InterruptedException{
        SharedResources sh = new SharedResources();
        SharedResources sh2 = new SharedResources();

        Thread t1 = new Thread(()->sh.test(sh2),"Thread-1");
        Thread t2= new Thread(()->sh2.test(sh),"Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }

}
