/*
*   Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
*   [-2,1-3,4,-1,2,1,-5,4] --> 6  [4,-1,2,1]
*/

public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) sum = 0;
            sum += nums[i];
            max = max > sum ? max : sum;
        }
        return max;
    }
/*
*   遍历，重点在于何时开始新的起点进行累加？
*   --》如果之前的结果<0，则舍弃。因为负数无论如何都会使累计和变小，所以 if(sum < 0) sum = 0; ，然后再给sum赋值。
*   所以，即，若sum<0 则重新起头，开始求和，并且在这个不断累加的过程中找出max
*/

//  Dynamic Programming
    public int dp(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int[] sum = new int[nums.length+1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i+1] = Math.max(sum[i] + nums[i], nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < sum.length; i++) {
            max = max > sum[i] ? max : sum[i];
        }
        return max;
    }
}
