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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        return dfs(root, sum);
    }

    private boolean dfs(TreeNode root, int remain) {
        remain -= root.val;
        if (root.left == null && root.right == null && remain == 0) {
            return true;
        }

        boolean left = false, right = false;
        if (root.left != null) {
            left = dfs(root.left, remain);
        }
        if (root.right != null) {
            right = dfs(root.right, remain);
        }

        return left || right;
    }
}
