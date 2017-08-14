/*
*   Given a binary tree, determine if it is a valid binary search tree. Assume a BST is defined as follows:
*   1. The left subtree of a node contains only nodes with keys less than the node's key.
*   2. The right subtree of a node contains only nodes with keys greater than the node's key.
*   3. Both the left and right subtrees must also be binary search trees.
*/

class ResultType {
    boolean isBST;
    int max, min;
    ResultType (boolean isBST, int max, int min) {
        this.isBST = isBST;
        this.max = max;
        this.min = min;
    }
}

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root).isBST;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        if (!left.isBST || !right.isBST) {
            return new ResultType(false, 0, 0);
        }
        if ((root.left != null && root.val <= left.max) ||
            (root.right != null && root.val >= right.min)) {
            return new ResultType(false, 0, 0);
        }
        return new ResultType(true, Math.max(root.val, right.max), Math.min(root.val, left.min));
    }
}
