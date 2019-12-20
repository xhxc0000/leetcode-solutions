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
    public TreeNode invertTree(TreeNode root) {
        dfs(root);

        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        dfs(root.left); dfs(root.right);
    }
}
