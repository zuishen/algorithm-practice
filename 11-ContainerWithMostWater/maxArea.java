/*
*   Given n non-negative integers a1, a2, ... , an, where each represents a point at coordinate (i, ai).
*   n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
*   Find two lines, which together with x-axis froms a container, such that the container contains
*   the most water.
*   Note: You may not slant the container and n is at least 2.
*/

//  如果用暴力解法，两重循环，求出每种情况下的容积，O(n^2)
//  可用双指针进行优化： 可以把这个解法看成j从len-1到0的暴力解法。
//                    又因为短板决定水容积，所以当[i]<=[j]时，无论怎么往回移，容积一定会减小，所以可以忽略后面的情况。
//                    从而直接i++即可。 反之，如果[i]>[j]时，则需要不断j--，因为可能遇到更大的[j]从而使容积增大。
// ** 这题变量因素有两个，一个是数组值的大小，另一个则为下标之差。让变量有规律的渐变从而优化。（递增？递减？）
class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int start = 0;
        int end = height.length - 1;
        int maxArea = 0;
        
        while (start < end) {
            max = Math(maxArea, Math.min(height[start], height[end]) * (end - start));
            if (height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }
        }      
        return maxArea;
    }
}
