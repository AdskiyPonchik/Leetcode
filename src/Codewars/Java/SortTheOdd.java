package Codewars.Java;

import java.util.Arrays;
import java.util.PrimitiveIterator;

public class SortTheOdd {
    public static int[] sortArray(int[] array) {
        PrimitiveIterator.OfInt odds = Arrays.stream(array).filter(i -> i%2!=0).sorted().iterator();
        return Arrays.stream(array).map(n -> n%2!=0 ? odds.nextInt() : n).toArray();
    }
}
