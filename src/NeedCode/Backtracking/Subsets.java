package NeedCode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, new ArrayList<>(), nums, result);
        return result;
    }

    private void backtrack(int index, List<Integer> current, int[] nums, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        backtrack(index + 1, current, nums, result);

        current.remove(current.size() - 1);

        backtrack(index + 1, current, nums, result);
    }

    public static void main(String[] args){
        Subsets solution = new Subsets();
        int[] arr = new int[]{1,2,1};
        System.out.println(Arrays.toString(solution.subsets(arr).toArray()));
    }
}
