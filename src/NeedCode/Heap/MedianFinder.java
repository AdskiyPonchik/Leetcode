package NeedCode.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    //Attention: to store smaller values;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    //Attention: to store bigger value;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public MedianFinder() {
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        while (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
