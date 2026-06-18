package NeedCode.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return !heap.isEmpty() ? heap.poll() : 0;
    }


    public static void main(String[] args){
        FindKthLargest test = new FindKthLargest();
        System.out.println(test.findKthLargest(new int[]{2,3,1,5,4}, 2));
    }
}
