package Codewars.Java;

import java.util.Arrays;

public class DataReverse {
    public static int[] dataReverse(int[] data) {
        int[] result = new int[data.length];
        for(int i = 0; i < data.length; i+=8){
            System.arraycopy(data, data.length-8-i, result, i, 8);
        }
        return result;
    }
}
