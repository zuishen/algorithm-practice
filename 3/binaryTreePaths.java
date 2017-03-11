/**
*   Given a binary tree, return all root-to-leaf paths.
*   For example, given the following binary tree:
*          1
*        /   \
*       2     3
*        \
*         5
*   All root-to-leaf paths are: ["1->2->5", "1->3"]
*/

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> results = new ArrayList<>();
        traverse(root, "", results);
        return results;
    }
    
    private void traverse(TreeNode root, String str, List<String> results) {
        if (root == null) {
            return;
        }
        str = str + root.val;
        if (root.left == null && root.right == null) {  // * check if the node is leaf node 
            results.add(str);
        } else {
            traverse(root.left, str + "->", results);
            traverse(root.right, str + "->", results);
        }
    }
}

