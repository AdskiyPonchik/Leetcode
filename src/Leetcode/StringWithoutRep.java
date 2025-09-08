package Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class StringWithoutRep {
    public static class Solution {
        public static int lengthOfLongestSubstring(String s) {
            int[] last = new int[256];
            Arrays.fill(last, -1);
            int left = 0, best = 0;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if (last[c] >= left) {
                    left = last[c] + 1;
                }
                last[c] = i;
                best = Math.max(best, i - left + 1);
            }
            return best;
        }
    }
}
