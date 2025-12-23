package Threads;

public class DeadLockDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread currentThread=Thread.currentThread();

        Thread t = new Thread(()->{
            System.out.println("Thread Start");
            try {
                currentThread.join();
            }catch (InterruptedException ex)
            {
                Thread.interrupted();
            }
            System.err.println("Thread end");
        });

        t.start();
        t.join();

    }
}
