package Codewars.Java;

import java.awt.event.MouseAdapter;

import static java.util.Arrays.stream;

public class HighAndLow {
    public static String highAndLow(String numbers) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(String s: numbers.split(" ")){
            int number = Integer.parseInt(s);
            low = Math.min(number, low);
            high = Math.max(number, high);
        }
        return high + " " + low;
    }

    public static String alterSolution(String numbers){
        var stats = stream(numbers.split(" ")).mapToInt(Integer::parseInt).summaryStatistics();
        return stats.getMax() + " " + stats.getMin();
    }

    public static void main(String[]args){
        System.out.println(highAndLow("1 2 -3 4 5"));
    }
}
