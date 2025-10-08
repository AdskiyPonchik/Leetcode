package Leetcode;

//Difficulty: Easy
import java.util.*;


public class PascalTriangle {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long num = 1;
        for (int i = 0; i <= rowIndex; i++) {
            row.add((int) num);
            num = num * (rowIndex - i) / (i + 1);
        }
        return row;
    }
}
