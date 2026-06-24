package NeedCode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(new ArrayList<>(), nums, used, result);
        return result;
    }

    private void backtrack(ArrayList<Integer> current, int[] nums, boolean[] used, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            current.add(nums[i]);
            used[i] = true;
            backtrack(current, nums, used, result);
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
