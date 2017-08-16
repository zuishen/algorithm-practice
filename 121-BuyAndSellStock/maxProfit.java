/*
*   Say you have an array for which the ith element is the price of a given stock on day i.
*   If you were only permitted to complete at most one transaction(buy one and sell), design an 
*   algorithm to find the maximum profit.
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = 1; i + j < prices.length; j++) {
                if (prices[i + j] - prices[i] > max) {
                    max = prices[i + j] - prices[i];
                }
            }
        }
        return max;
    }
    
    public int maxProfit(int[] prices) {
        if (prices == null) return 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
}
