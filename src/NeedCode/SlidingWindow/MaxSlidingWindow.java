package NeedCode.SlidingWindow;

import java.util.ArrayDeque;
import java.util.Arrays;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                result[i-k+1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args){
        MaxSlidingWindow test = new MaxSlidingWindow();
        System.out.println(Arrays.toString(test.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3}, 3)));
    }
}
