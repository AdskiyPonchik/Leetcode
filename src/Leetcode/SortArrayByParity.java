package Leetcode;

// Difficulty: Easy

public class SortArrayByParity {
    /*
    public int[] sortArrayByParity(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int odd_length = 0;
        int even_length = 0;
        for(int i: nums){
            if(i%2==0){
                result[even_length] = i;
                even_length++;
            }else{
                result[length - odd_length - 1] = i;
                odd_length++;
            }
        }
        return result;
    }
     */
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[right] % 2 == 0) {
                if (nums[left] % 2 == 0) {
                    left++;
                } else {
                    int test = nums[left];
                    nums[left] = nums[right];
                    nums[right] = test;
                    right--;
                    left++;
                }
            }else{
                right--;
            }
        }
        return nums;
    }
}