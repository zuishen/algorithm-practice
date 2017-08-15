/*
*   Given a binary tree and a sum, determine if the tree has a root-to-leaf path
*   such that adding up all the values along the path equals the given sum.
*/
//  sum依次减去每个node.val，当结点为叶子结点，并且sum-node.val为0时，则为找到path。
//  需要检测叶子结点，如果不检测，则会造成sum - node.val == 0 && 只有一个孩子 的情况误判为找到path

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            if (sum - root.val == 0) return true;
            else return false;
        }
        boolean left = hasPathSum(root.left, sum - root.val);
        if (left) return true;
        boolean right = hasPathSum(root.right, sum - root.val);
        if (right) return true;
        return false;
    }
}
