/*
*   Given a binary tree, check whether it is a mirror of itself.
*   [1,2,2,3,4,4,3] is symmetric; [1,2,2,null,3,null,3] is not.
*/

public class Solution {
    public boolean isSymmetricR(TreeNode root) {
        return isEqual(root, root);
    }
    
    public boolean isEqual(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return (root1.val == root2.val) &&
            isEqual(root1.left, root2.right) &&
            isEqual(root1.right, roo2.left);
    }
    
    public boolean isSymmetricI(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root);
        q2.add(root);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();
            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;
            if (node1.val != node2.val) return false;
            q1.add(node1.left);
            q1.add(node1.right);
            q2.add(node2.right);
            q2.add(node2.left);
        }
        if (q1.isEmpty() && q2.isEmpty()) return true;
        return false;
    }
}
/*
*   左右对称，可用两棵树进行比较。
*   条件  root.val相等，左子树与对应结点的右子树相同，右子树与对应结点的左子树相同 O(n), O(1)
*   非递归方法则与bfs有些相似 O(n), O(n)
*/
