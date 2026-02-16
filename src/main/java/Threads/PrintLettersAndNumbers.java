package Threads;

public class PrintLettersAndNumbers
{
    private static final Object monitor = new Object();
    private static int limit=26;
    private static volatile boolean isLetter=false;

    public static void main(String[] args) {

        Thread letterThread = new Thread(()->{
            for (char ch='A'; ch<'A'+limit;ch++)
            {
                synchronized (monitor)
                {
                    while (isLetter)
                    {
                        try {
                           monitor.wait();
                        }catch (InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }

                    System.out.print(ch+" ");
                    isLetter=true;
                    monitor.notify();
                }

            }
        });



        Thread number = new Thread(()->{
            for (int i=1; i<=limit;i++)
            {
                synchronized (monitor)
                {
                    while (!isLetter)
                    {
                        try {
                            monitor.wait();
                        }catch (InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }

                    System.out.print(i+" ");
                    isLetter=false;
                    monitor.notify();
                }
            }
        });


        letterThread.start();
        number.start();
    }
}
