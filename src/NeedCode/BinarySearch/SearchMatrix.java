package NeedCode.BinarySearch;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0, right = rows*cols - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(matrix[mid/cols][mid%cols] == target){
                return true;
            }
            if(matrix[mid/cols][mid%cols] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
       return false;
    }

    public static void main(String[] args) {
        SearchMatrix sol = new SearchMatrix();
        int[][] matrix1 = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target1 = 3;
        System.out.println("Test 1 (Target 3): " + sol.searchMatrix(matrix1, target1));

        int target2 = 13;
        System.out.println("Test 2 (Target 13): " + sol.searchMatrix(matrix1, target2));

        int[][] matrix3 = {};
        System.out.println("Test 3 (Empty Matrix): " + sol.searchMatrix(matrix3, 5));
    }
}
