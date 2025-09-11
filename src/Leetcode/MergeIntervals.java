package Leetcode;

import java.util.*;

// Difficulty: Medium

public class MergeIntervals {
    public static class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) return new int[0][0];
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            List<int[]> merged = new ArrayList<>();
            merged.add(intervals[0]);
            for(int i = 1; i < intervals.length; i++){
                int[] lastInterval = merged.get(merged.size()-1);
                int[] currentInterval = intervals[i];
                if(lastInterval[1] >= currentInterval[0]){
                    lastInterval[1] = Math.max(lastInterval[1], currentInterval[1]);
                }else{
                    merged.add(currentInterval);
                }
            }
            return merged.toArray(new int[merged.size()][]);
        }
    }
}
