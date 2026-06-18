package NeedCode.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones){
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone: stones){
            heap.offer(stone);
        }
        while(heap.size() > 1){
            int stone1 = heap.poll();
            int stone2 = heap.poll();
            if(stone1!=stone2) {
                heap.offer(stone1 - stone2);
            }
        }
        return heap.isEmpty() ? 0 : heap.poll();
    }
}
