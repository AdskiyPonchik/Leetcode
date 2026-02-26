package NeedCode.BinarySearch;

public class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while(left < right){
            int mid = left + (right-left)/2;
            long totalHours = 0;
            for(int pile: piles){
                totalHours += (pile+mid-1)/mid;
            }
            if(totalHours <= h){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}
