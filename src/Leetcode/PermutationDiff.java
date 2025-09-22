package Leetcode;

import java.util.HashMap;
import java.util.Map;

//Difficulty: Easy

//task solved in 4 minutes

public class PermutationDiff {
    public int findPermutationDifference(String s, String t) {
        Map<Character, Integer> firstString = new HashMap<>();
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            firstString.put(s.charAt(i), i);
        }
        for(int i = 0; i < t.length(); i++){
            int num1 = firstString.get(t.charAt(i));
            result+= Math.abs(num1-i);
        }

        return result;
    }
}
