package Leetcode;

/*

Input: prices = [7,6,5,4,1,3]
Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
 */

public class MaxProfit {
    public static class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0;
            int buy_price = -1;
            int sell_price = 0;
            int i = 0;
            while (i < prices.length - 1){
                if( prices[i] < prices[i+1]){
                    buy_price = prices[i];
                }
                while(i+1 < prices.length && prices[i] < prices[i+1]){
                    i++;
                }
                sell_price = prices[i];
                if(buy_price!=-1) {
                    profit += sell_price - buy_price;
                    buy_price = -1;
                }
                i++;
            }
            return profit;
        }
    }
}
