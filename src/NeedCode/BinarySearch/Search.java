package NeedCode.BinarySearch;

public class Search {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if(nums[mid] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Search binSearch = new Search();
        System.out.println(binSearch.search(new int[]{-1,0,2,4,6,8}, 4));
    }

}
