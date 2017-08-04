/*
*   Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
*   Do not allocate extra space for another array, you must do this in place with constant memory.
*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;   
        }
        int slow = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[slow] = nums[i];
                slow++;
            }
        }
        return slow;
    }
}

/*
*   Since the array is already sorted, we can keep two pointers i and slow, where slow is the slower-runner 
*   while i is the fast-runner. As long as nums[i] = nums[j], we increment i to skip the duplicate.
*   
*   When we encounter nums[i-1] != nums[i], the duplicate run has ended so we must copy its value to nums[slow] 
*   and increment slow.
*/
