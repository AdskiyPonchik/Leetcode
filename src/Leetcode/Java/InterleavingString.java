package Leetcode;

// Difficulty: Medium

public class InterleavingString {
    class Solution{
        public boolean isInterleave(String s1, String s2, String s3){
            if(s1.length() + s2.length() != s3.length()){return false;}
            boolean[] dp = new boolean[s2.length()+1];
            for(int i = 0; i <= s1.length(); i++){
                for(int j = 0; j <= s2.length();j++) {
                    if (i == 0 && j == 0) {
                        dp[j] = true;
                    } else {
                        boolean takeS1 = i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[j];
                        boolean takeS2 = j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[j - 1];
                        dp[j] = takeS2||takeS1;
                    }
                }
            }
            return dp[s2.length()];
        }
    }
}
