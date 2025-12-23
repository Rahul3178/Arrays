package Threads;
class SharedResource{

    public synchronized void test(SharedResource resource)
    {
        System.out.println("Method test triggered"+Thread.currentThread().getName());
        try {

            System.out.println("Triggered 2nd method from method 1"+Thread.currentThread().getName());
            Thread.sleep(5000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        resource.test2();
    }

    public synchronized void test2()
    {
        System.out.println("Test 2 triggered"+Thread.currentThread().getName());
    }
}

public class ThreadDemo2 {

    public static void main(String[] args) throws InterruptedException{
        SharedResource sh = new SharedResource();
        SharedResource sh2 = new SharedResource();

        Thread t1 = new Thread(()->sh.test(sh2),"Thread-1");
        Thread t2= new Thread(()->sh2.test(sh),"Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }

}
