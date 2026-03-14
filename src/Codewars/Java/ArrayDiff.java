package Codewars.Java;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayDiff {
    public static int[] arrayDiff(int[] a, int[] b) {
        Set<Integer> map = Arrays.stream(b).boxed().collect(Collectors.toSet());
        return Arrays.stream(a).filter(x -> !map.contains(x)).toArray();
    }
}
