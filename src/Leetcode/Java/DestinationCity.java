package Leetcode;

import java.util.*;

// Difficulty: Easy

public class DestinationCity {
    class Solution {
        public String destCity(List<List<String>> paths) {
            Set<String> hash = new HashSet<String>();
            for (List<String> i : paths) {
                hash.add(i.get(0));
            }
            for (List<String> i : paths) {
                String to = i.get(1);
                if (!hash.contains(to)) return to;
            }
            return "";
        }
    }
}
