package Threads.producersIssues;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerPart2
{
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        Thread producer = new Thread(()->{
            for (int i = 0; i < 30; i++) {
                try {
                    queue.put(i);
                    System.out.println("Producer \t"+i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(()->{
            try {
                    Thread.sleep(2000);
                while (queue.size() > 0) {
                    Thread.sleep(1000);
                   int value= queue.take();
                    System.out.println("Consumer \t"+value);
                }
            }catch (InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
