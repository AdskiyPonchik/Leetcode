package NeedCode.SlidingWindow;

import java.util.Set;
import java.util.HashSet;

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> storage = new HashSet<>();
        int result = 0;
        int r = 0, l = 0;
        while (r < s.length()) {
            if (!storage.contains(s.charAt(r))) {
                storage.add(s.charAt(r));
                result = Math.max(result, storage.size());
                r++;
            } else {
                storage.remove(s.charAt(l));
                l++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("xxxx"));
    }
}
