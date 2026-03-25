package Codewars.Java;

public class Snail {

    public static int[] snail(int[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return new int[0];
        }
        int n = array.length;
        int[] result = new int[n * n];
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int index = 0;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result[index++] = array[top][i];
            }
            top++;
            for(int i = top; i <= bottom; i++){
                result[index++] = array[i][right];
            }
            right--;
            if(top<=bottom){
                for(int i = right; i >= left; i--){
                    result[index++] = array[bottom][i];
                }
                bottom--;
            }
            if(left<=right){
                for(int i = bottom; i >= top; i--){
                    result[index++] = array[i][left];
                }
                left++;
            }

        }
        return result;
    }
}
