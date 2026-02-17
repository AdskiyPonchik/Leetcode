package NeedCode.SlidingWindow;

class Solution {
    public static int maxProfit(int[] prices) {
        int result = 0;
        int r = 0;
        int l = 0;
        while(r < prices.length){
            if(prices[r] < prices[l]){
                l = r;
                r++;
                continue;
            }
            int localresult = prices[r]-prices[l];
            result = Math.max(localresult, result);
            r++;
        }
        return result;
    }

    public static void main(String[] args){
        int[] a = new int[]{10,8,7,5,2};
        System.out.println(maxProfit(a));
    }
}
