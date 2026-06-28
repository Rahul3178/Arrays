package Threads.VirtualThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) {
//      Thread.startVirtualThread(()->{System.out.println("Hello java");});

        ThreadFactory factory= Thread.ofVirtual().name("Vt-",0).factory();

        try(ExecutorService ex = Executors.newThreadPerTaskExecutor(factory))
        {

                for (int i = 0; i < 1_000_000; i++) {
                    ex.execute(()->{

                        try {
                            System.out.print(Thread.currentThread().getName()+"| Virtual = "+Thread.currentThread().isVirtual());
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    });

                }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
