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
    
    public int[] twoSumBinarySearch(int[] numbers, int target) {
        if (numbers == null) {
            return null;
        }
        for (int i = 0; i < numbers.length; i++) {
            int tmp = binarySearch(i + 1, target - numbers[i], numbers);
            if (tmp > 0) {
                return new int[]{i + 1, tmp + 1};
            }
        }
        return null;
    }
    
    private int binarySearch(int start, int target, int[] num) {
        int end = num.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target == num[mid]) {
                return mid;
            } else if (target > num[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (target == num[start]) {
            return start;
        }
        if (target == num[end]) {
            return end;
        }
        return - 1;
    }
}
        
        
