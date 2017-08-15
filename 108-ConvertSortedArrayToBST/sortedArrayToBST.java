/*
*   Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
*/
// 可用 binary search 的类似方法来做这道题，左边小于root，root小于右边，与二分查找的特点一致。但需注意结束的调节，以及当start和
// end为同一个节点时的处理

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildTree(0, nums.length - 1, nums);
    }
    
    private TreeNode buildTree(int start, int end, int[] nums) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(start, mid - 1, nums);
        root.right = buildTree(mid + 1, end, nums);
        
        return root;
    }
}
