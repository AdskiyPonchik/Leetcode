package NeedCode.BinarySearch;

public class Median {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int n = nums1.length;
        int m = nums2.length;
        int left = 0, right = n;
        while(left <= right){
            int i = left + (right-left)/2;
            int j = (m + n + 1)/2 - i;
            int L1 = (i==0) ? Integer.MIN_VALUE : nums1[i-1];
            int R1 = (i==n) ? Integer.MAX_VALUE : nums1[i];
            int L2 = (j==0) ? Integer.MIN_VALUE : nums2[j-1];
            int R2 = (j==m) ? Integer.MAX_VALUE : nums2[j];
            if(L1 <= R2 && L2 <=R1){
                if((m+n)%2==0){
                    return (Math.max(L1,L2) + Math.min(R1,R2))/2.0;
                }else{
                    return Math.max(L1,L2);
                }
            } else if (L1 > R2) {
                right = i-1;
            }else{
                left = i+1;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        int[] a = new int[]{1,2};
        int[] b = new int[]{3,4};
        Median test = new Median();
        System.out.println(test.findMedianSortedArrays(a, b));
    }
}
