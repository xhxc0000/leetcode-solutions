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
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    private int dfs(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        int leave = 0;
        if (isLeft && root.left == null && root.right == null) {
            leave = root.val;
        }

        int left = dfs(root.left, true);
        int right = dfs(root.right, false);

        return left + right + leave;
    }
}
