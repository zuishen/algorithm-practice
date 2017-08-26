/*
*   Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
*   Return the sum of the three integers. You may assume that each input would have exactly one solution.
*   [-1, 2, 1, -4], target = 1   ===>  (-1 + 2 + 1 = 2)
*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int tmp = nums[i] + nums[start] + nums[end];
                sum = Math.abs(target - tmp) < Math.abs(target - sum) ? tmp : sum;
                if (tmp == target) {
                    return tmp;
                } else if (tmp < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return sum;
    }
}
