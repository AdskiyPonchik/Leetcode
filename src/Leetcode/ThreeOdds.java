package Leetcode;

// Difficulty: Easy
// lol. Solved in 1 minute.

public class ThreeOdds {
    class Solution {
        public boolean threeConsecutiveOdds(int[] arr) {
            int counter = 0;
            for (int i = 0; i < arr.length; i++) {
                if (counter == 3) {
                    return true;
                }
                if (arr[i] % 2 != 0) {
                    counter++;
                } else {
                    counter = 0;
                }
            }
            return counter >= 3;
        }
    }
}
