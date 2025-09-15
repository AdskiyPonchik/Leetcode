package Leetcode;

import java.util.Arrays;

public class FindTheDifference {
    class Solution {
        //best solution
        public char findTheDifference(String s, String t){
            int sum = 0;
            for(char c:s.toCharArray()) sum+=c;
            for(char c:t.toCharArray()) sum-=c;
            return (char)sum;
        }
        /*
        public char findTheDifference(String s, String t) {
            char[] some = s.toCharArray();
            char[] tome = t.toCharArray();
            Arrays.sort(some);
            Arrays.sort(tome);
            for (int i = 0; i < some.length; i++) {
                if (some[i] != tome[i]) {
                    return tome[i];
                }
            }
            return tome[tome.length-1];
        }
         */
    }
}