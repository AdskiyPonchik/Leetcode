package Leetcode;

// Difficulty: Medium

public class Sqrt {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 1;
        int right = x;
        int mid = -1;
        while (left <= right) {
            mid =left + (right - left) / 2;
            if ((long) mid * mid > (long) x) {
                right = mid - 1;
            } else if (mid * mid == x) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
        return Math.round(right);
    }

    public static void main(String[] args) {
        Sqrt something = new Sqrt();
        System.out.println(something.mySqrt(8));
    }
}
