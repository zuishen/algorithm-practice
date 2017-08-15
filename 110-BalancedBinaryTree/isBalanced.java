/*
*   Given a binary tree, determine if it is height-balanced.
*   For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
*   of every node never differ by more than 1
*/
//  求出每个结点的最大深度，然后根据balanced binary tree条件进行处理
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (helper(root) < 0) return false;
        else return true;
    }
    
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if (left < 0 || right < 0) return -1;
        if (Math.abs(left - right) > 1) return -1;
        
        return Math.max(left, right) + 1;
    }
}
