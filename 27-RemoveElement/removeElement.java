/*
*   Given an array and a value, remove all instances of that value in place and return the new length.
*   Do not allocate extra space for another array, you must do this in place with constant memory.
*   The order of elements can be changed.
*       Example: [3,2,2,3] val=3  ==> return 2;  [2,2,3,3]
*/

public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;   
        }
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
            }
            if (nums[i] != val) i++;
        }
        return i;
    }
}
/*
*   two pointers i and j, swap the value with nums[j] if nums[i] equals to val then j subtracts 1
*   if the current value don't equal to val, then add 1 to i.
*/
