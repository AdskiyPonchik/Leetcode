package Leetcode;

// Difficulty: Easy
// first solution is a bullshit.

public class PlusOne {
    class Solution {
        /* First solution*/
//        public int[] plusOne(int[] digits) {
//            int index = digits.length - 1;
//            boolean carry = true;
//            while (carry) {
//                if (digits[index] + 1 == 10) {
//                    if (index == 0) {
//                        int[] new_arr = new int[digits.length + 1];
//                        new_arr[0] = 1;
//                        return new_arr;
//                    } else {
//                        digits[index]=0;
//                        index--;
//                    }
//                } else {
//                    digits[index] += 1;
//                    index--;
//                    carry = false;
//                }
//            }
//            return digits;
//        }

        public int [] plusOne(int[] digits){
            for(int i = digits.length-1; 0 <=i; i++){
                if(digits[i] < 9){
                    digits[i]++;
                    return digits;
                }
                digits[i] = 0;
            }
            int[] result = new int[digits.length+1];
            result[0] = 1;
            return result;
        }
    }
}
