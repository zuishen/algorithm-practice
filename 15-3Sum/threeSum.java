/*
*   Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
*   Find all unique triplets in the array which gives the sum of zero.
*   Note solution set must not contain duplicate triplets.
*
*   S = [1, 0, 1, 2, -1, -4]
*   [
*       [-1, 0, 1],
*       [-1, -1, 2]
*   ]
*/

// 最外层循环找target，里层找2sum，但是因为结果要求返回不重复的三元组，因此是一个求组合问题
// 组合与排列的差别在于相同的数，因此，只要跳过所有的相同的数，即可去掉所有重复的组合。
// 那么如何跳过相同的数？ 可以将数组排序
// 又因为数组是有序的了，所以可以用双指针来做




