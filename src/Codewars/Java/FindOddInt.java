package Codewars.Java;

import java.util.HashMap;
import java.util.Map;

public class FindOddInt {
    public static int findIt(int[] a){
        int result = 0;
        for(int c : a){
            result^=c;
        }
        return result;
    }
    public static int findItAlt(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            map.merge(i, 1, Integer::sum);
        }
        for (int c : map.keySet()) {
            if (map.get(c) % 2 != 0) {
                return c;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findIt(new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5}));
    }
}
