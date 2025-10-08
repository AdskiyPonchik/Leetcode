package Leetcode;

import java.util.Arrays;

//Difficulty: Easy

public class SplitNum {
    //actually great solution
    public static class Solution {
        public int splitNum(int num) {
            int num1 = 0;
            int num2 = 0;
            char[] digits = String.valueOf(num).toCharArray();
            Arrays.sort(digits);
            for(int i = 0; i<digits.length; i++){
                if(i%2==0){
                    num1 = num1*10 +Character.getNumericValue(digits[i]);
                    continue;
                }
                num2 = num2*10 +Character.getNumericValue(digits[i]);
            }
            return num1+num2;
        }
    }
}
