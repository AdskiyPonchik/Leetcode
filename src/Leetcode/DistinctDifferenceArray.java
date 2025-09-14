package Leetcode;

import java.util.*;

// Difficulty: Easy

public class DistinctDifferenceArray {
    class Solution{
        public int[] distinctDifferenceArray(int[] nums){
            int length = nums.length;
            int[] prefix = new int[length];
            int[] suffix = new int[length+1];
            int[] result = new int[length];
            Set<Integer> hashset = new HashSet<>();
            for(int i=0; i <length; i++){
                hashset.add(nums[i]);
                prefix[i] = hashset.size();
            }
            hashset.clear();
            for(int i = length-1;0 <= i; i--){
                hashset.add(nums[i]);
                suffix[i] = hashset.size();
            }
            hashset.clear();
            for(int i = 0; i < length; i++){
                result[i] = prefix[i] - suffix[i+1];
            }
            return result;
        }
    }
}
