package NeedCode.Heap;

import java.util.PriorityQueue;

public class kClosest {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][];
        PriorityQueue<int[]> heap = new PriorityQueue<>(k, (a, b) ->
                Integer.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1])));
        for(int[] point: points){
            heap.offer(point);
            if(heap.size() > k){
                heap.poll();
            }
        }
        int i=0;
        while(!heap.isEmpty() && i < k){
            result[i++] = heap.poll();
        }
        return result;
    }
}
