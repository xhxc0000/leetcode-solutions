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
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);

        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int sum = root.val;
        int left = dfs(root.left);
        int right = dfs(root.right);
        sum += left + right;
        max = Math.max(max, sum);

        return Math.max(0, Math.max(left, right) + root.val);
    }
}
