package Threads.producersIssues;

import java.util.LinkedList;
import java.util.Queue;

class Shared{
    private final int capacity=10;
    Queue<Integer> queue= new LinkedList<>();

    public synchronized void ProduceItem(int i)
    {
        while (queue.size()==10)
        {
            try {
                wait();
            }catch (InterruptedException ex)
            {
                Thread.currentThread().interrupt();
                break;
            }
        }
        queue.offer(i);
        System.out.println("Produced \t"+i);
        notifyAll();
    }

    public synchronized void ConsumedItem()
    {
        while (queue.size()==0)
        {
            try {
                wait();
            }catch (InterruptedException ex)
            {
                Thread.currentThread().interrupt();
                break;
            }
        }

        int value=queue.poll();
        System.out.println("Consumed \t"+value);
        notifyAll();
    }

}

public class ProducerConsumerProblem
{
    public static void main(String[] args) {

        Shared sh = new Shared();
        Thread producer = new Thread(()->{
            for (int i = 0; i <30 ; i++) {

                sh.ProduceItem(i);

            }
        });

        Thread consumer = new Thread(()->{

                try {
                    Thread.sleep(1000);
                    while (sh.queue.size()>0) {
                        Thread.sleep(1000);
                        sh.ConsumedItem();
                    }
                }catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }

        });

        producer.start();
        consumer.start();
    }
}
