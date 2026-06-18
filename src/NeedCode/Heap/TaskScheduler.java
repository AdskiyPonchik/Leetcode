package NeedCode.Heap;

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if (tasks.length == 0) {
            return 0;
        }
        int[] freq = new int[26];
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (char c : tasks) {
            freq[c - 'A']++;
        }
        for (int f : freq) {
            if (f > 0) {
                heap.offer(f);
            }
        }
        Queue<int[]> cooldownList = new LinkedList<>();
        int time = 0;
        while (!heap.isEmpty() || !cooldownList.isEmpty()) {
            time++;
            if (!cooldownList.isEmpty() && cooldownList.peek()[1] == time) {
                heap.offer(cooldownList.poll()[0]);
            }
            if (!heap.isEmpty()) {
                int newFreq = heap.poll() - 1;
                if (newFreq > 0) {
                    cooldownList.add(new int[]{newFreq, time + n + 1});
                }
            }
        }
        return time;
    }
}

