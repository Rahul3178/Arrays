package deleted;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement
{
    public static void main(String[] args) {

        int[] array={5,7,3,6,2,9};
        int k=2; // output will be 7

        PriorityQueue<Integer> minHeap= new PriorityQueue<>(k); // min element at the top

        for (int x:array)
        {
            minHeap.add(x);
            if (minHeap.size()>k)
            {
                minHeap.poll();
            }
        }

        System.out.println(k+"th\tlargest element is :"+minHeap.peek());

        PriorityQueue<Integer> maxHeap= new PriorityQueue<>(Collections.reverseOrder()); // maximum element at the top
        for (int x:array)
        {
            maxHeap.offer(x);
            if (maxHeap.size()>k)
            {
                maxHeap.poll();
            }
        }

        System.out.println(k+"th\tsmallest element is :"+maxHeap.peek());
    }
}
