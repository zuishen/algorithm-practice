/*
*   Say you have an array for which the ith element is the price of a given stock on day i.
*   Design an algorithm to find the maximum profit. You may complete as many transactions as
*   you like (buy one and sell one share of the stock multiple times). However, you may not engage 
*   in multiple transactions at the same time (you must sell the stock before you buy again)
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int i = 0;
        int peak = 0;
        int vally = 0;
        int sum = 0;
        
        while (i < prices.length) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            vally = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            i++;
            sum += peak - vally;
        }
        return sum;
    }
}
