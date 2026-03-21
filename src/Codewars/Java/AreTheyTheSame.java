package Codewars.Java;

import java.util.Arrays;

public class AreTheyTheSame {
    public static boolean comp(int[] a, int[] b) {
        if(a==null || b==null || a.length!=b.length){return false;}
        var A = Arrays.stream(a).mapToLong(x -> (long)x*x).toArray();
        var B = Arrays.stream(b).mapToLong(x -> (long) x).toArray();
        Arrays.sort(A);Arrays.sort(B);
        return Arrays.equals(A,B);
    }
}
