package NeedCode.BinarySearch;

public class FindMin {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left<right){
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[right]){
                left = mid+1;
            }
            else if(nums[mid] < nums[right]){
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args){
        FindMin test = new FindMin();
        System.out.println(test.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }
}
