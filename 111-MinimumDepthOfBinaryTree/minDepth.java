/*
*   Given a binary tree, find its minimum depth.
*   The minimum depth is the number of nodes along the shortest path 
*   from the root node down to the nearest leaf node.
*/
//  注意当结点仅有一个子结点时，子结点的depth与0比较应该取最大值。
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        if (root.left != null && root.right != null) {
            return Math.min(left, right) + 1;
        } else {
            return Math.max(left, right) + 1;
        }
    }
}
