/*
*   Given a binary tree, return the bottom-up level order traversal of its nodes' value
*   (from left to right, level by level from leaf to root)
*/

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> curr = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        curr.offer(root);
        
        while (!curr.isEmpty()) {
            TreeNode node = curr.poll();
            if (node == null) continue;
            tmp.add(node.val);
            if (node.left != null) next.offer(node.left);
            if (node.right != null) next.offer(node.right);
            if (curr.isEmpty()) {
                result.add(0, tmp);
                tmp = new ArrayList<>();
                curr = next;
                next = new LinkedList<>();
            }
        }
        return result;
    }
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
           
    }
    
}
