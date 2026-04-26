package NeedCode.LinkedList;

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args){
        FindDuplicate test = new FindDuplicate();
        System.out.println(test.findDuplicate(new int[]{1,3,4,2,2}));
    }
}
