/*
*   Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
*   You may assume that nums1 has enough space (size that is greater or equal to m+n) to hold additional elements from nums2.
*   The number of elements initialized in nums1 and nums2 are m and n respectively.
*/

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            return;
        }
        int i = m - 1;
        int j = n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[i + j + 1] = nums1[i];
                i--;
            } else {
                nums1[i + j + 1] = nums2[j];
                j--;
            }
        }
    }
}
/*
*   因为是有序数列，所以可按顺序直接比较。又因为后面有足够空间，所以可以从数组末尾一一对比，并将结果放入数组的最后。
*   i + j + 1 最大可为 m-1 + n-1 + 1，为合并后的位置。 因为当nums1为空时i为-1，从而j决定位置，所以可以覆盖当其中当1数组移完的情况。
*   外面的大循环则控制当2数组移完的情况。复杂度为O(n), O(1).
*/
