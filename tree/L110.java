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

    private boolean balance = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);

        return balance;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        if (Math.abs(left - right) > 1) balance = false;

        return Math.max(left, right) + 1;
    }
}
