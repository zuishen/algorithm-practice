/*
*   Given two binary trees, write a function to check if they are equal or not.
*   Two binary trees are considered equal if they are structurally indentical and nodes have the same value.
*/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        
        if (left && right) return true;
        return false;
    }
}

/*
*           O(n) if n < m , O(1)
*   AVG:    O(log n)?
*/

