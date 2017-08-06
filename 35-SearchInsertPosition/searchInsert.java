/*
*   Given a sorted array and a target value, return the index if the target is found.
*   If not, return the index where it would be if it were inserted in order. (assume no duplicates in the array.)
*    
*   [1,3,5,6],5 -> 2;  2->1;    7->4;   0->0;   
*/

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target > nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (target <= nums[start]) {
            return start;
        } else if (target <= nums[end]) {
            return end;
        } else {
            return end + 1;
        }
    }
}
