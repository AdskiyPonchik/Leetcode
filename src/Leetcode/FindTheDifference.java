package Leetcode;

//Difficulty: Easy

public class FindTheDifference {
    public static class Solution {
        //best solution
        public char findTheDifference(String s, String t){
            int xor = 0;
            for(char c:s.toCharArray()) xor^=c;
            for(char c:t.toCharArray()) xor^=c;
            return (char)xor;
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