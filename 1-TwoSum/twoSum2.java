/*
*   Given an array of integers that is already sorted in ascending order, find two numbers such that they
*   add up to a specific target number.
*   The function twoSum should return indices of the two numbers such that they add up to the target, 
*   where index1 must be less than index2. Please note that your returned answers (both index1 and index2)
*   are not zero-based.
*
*/
//  Two pointers
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null) {
            return null;
        }
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (target - numbers[i] == numbers[j]) {
                return new int[]{i + 1, j + 1};
            } else if (target - numbers[i] > numbers[j]) {
                i++;
            } else {    // target - numbers[i] < numbers[j]
                j++;
            }
        }
        return null;
    }
}
        
        
