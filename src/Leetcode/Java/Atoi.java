package Leetcode;


// TODO: Completed
// Difficulty: Medium

public class Atoi {
    public static class Solution{
        public int myAtio(String s){
            if (s == null || s.isEmpty()) return 0;
            int i = 0, n = s.length();
            while (i < n && s.charAt(i) == ' ') i++;
            if (i == n) return 0;
            int sign = 1;
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                sign = (s.charAt(i) == '-') ? -1 : 1;
                i++;
            }
            long result = 0;
            while (i < n && Character.isDigit(s.charAt(i))) {
                int digit = s.charAt(i) - '0';
                if (result > (Integer.MAX_VALUE - digit) / 10) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result = result * 10 + digit;
                i++;
            }
            return (int) (sign * result);
        }
    }
}
