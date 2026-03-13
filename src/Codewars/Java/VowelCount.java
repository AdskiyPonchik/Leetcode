package Codewars.Java;

import java.util.HashMap;
import java.util.Map;

public class VowelCount {
    public static int getCount(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ("aeiou".indexOf(c) != -1) result++;
        }
        return result;
    }
}
