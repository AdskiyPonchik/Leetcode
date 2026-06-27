package NeedCode.Backtracking;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        quicksort(nums, 0, nums.length - 1);
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
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }

        backtrack(index + 1, current, nums, result);

    }

    private int partition(int[] arr, int low, int high) {
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < arr[high]) {
                i++;
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }
        int tmp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = tmp;
        return i + 1;
    }

    private void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotId = partition(arr, low, high);
            quicksort(arr, low, pivotId - 1);
            quicksort(arr, pivotId + 1, high);
        }
    }

}
