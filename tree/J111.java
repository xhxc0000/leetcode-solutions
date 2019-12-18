/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left != null && root.right != null) {
            return Math.min(dfs(root.left), dfs(root.right)) + 1;
        } else {
            return root.left == null ? dfs(root.right) + 1 : dfs(root.left) + 1;
        }
    }
}
