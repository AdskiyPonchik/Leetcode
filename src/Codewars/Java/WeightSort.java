package Codewars.Java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

public class WeightSort {
    public static String orderWeight(String strng) {
        return Arrays.stream(strng.trim().split("\\s+"))
                .sorted(Comparator.comparingInt(WeightSort::sumDigits).thenComparing(x->x)).collect(Collectors.joining(" "));
    }
    private static int sumDigits(String s){
        int result = 0;
        for(char c: s.toCharArray()){
            result += c - '0';
        }
        return result;
    }

    public static void main(String[]args){
        System.out.println(Objects.equals(orderWeight("56 65 74 100 99 68 86 180 90"), "100 180 90 56 65 74 68 86 99"));
    }
}
