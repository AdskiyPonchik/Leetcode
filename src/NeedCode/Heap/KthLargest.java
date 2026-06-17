package NeedCode.Heap;

import java.util.PriorityQueue;

public class KthLargest {
    private final PriorityQueue<Integer> heap;
    private final int k;
    public KthLargest(int k, int[] nums){
        this.k = k;
        this.heap = new PriorityQueue<>(k);

        for(int num: nums){
            add(num);
        }
    }

    public int add(int val){
        heap.offer(val);

        if (heap.size() > k) {
            heap.poll();
        }

        return heap.peek();
    }
}
