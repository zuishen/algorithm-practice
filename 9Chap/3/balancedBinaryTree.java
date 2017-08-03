/**
*   Given a binary tree, determine if it is height-balanced.
*
*   For this problem, a height-balanced binary tree is defined as a binary tree in which the depth
*   of the twoo subtrees of every node never differ by more than 1.
*
* Definition for a binary tree node.
* public class TreeNode {
*     int val;
*     TreeNode left;
*     TreeNode right;
*     TreeNode(int x) { val = x; }
* }
*/
 
public class Solution {
    public class ResultType {       // inner class
        boolean isBalanced;
        int maxDepth;
        public ResultType(boolean isBalanced, int maxDepth) {
            this.isBalanced = isBalanced;
            this.maxDepth = maxDepth;
        }
    }
 
    public boolean isBalanced(TreeNode root) {
        ResultType result = divideNConquer(root);
        return result.isBalanced;
    }
    
    private ResultType divideNConquer(TreeNode root) {
        if (root == null) {
            return new ResultType(true, 0);
        }
        ResultType left = divideNConquer(root.left);
        ResultType right = divideNConquer(root.right);
        
        boolean isBalanced = left.isBalanced && right.isBalanced & Math.abs(left.maxDepth - right.maxDepth) <= 1;
        int maxDepth = Math.max(left.maxDepth, right.maxDepth) + 1; // consider alg first so that some steps will not be ommited
        
        return new ResultType(isBalanced, maxDepth);
    }
    
    // public boolean isBalanced(TreeNode root) {
    //     if (root == null) {
    //         return true;
    //     }
    //     int ret = helper(root);
    //     return ret == -1 ? false : true; 
    // }
    
    // private int helper(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     int left = helper(root.left);
    //     int right = helper(root.right);
        
    //     if (left == -1 || right == -1) {
    //         return -1;
    //     }
    //     if (Math.abs(left - right) > 1) {
    //         return -1;
    //     }
    //     return Math.max(left, right) + 1;
    // }
}
