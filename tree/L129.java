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

    private int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;

        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int val) {
        val *= 10;
        val += root.val;

        if (root.left == null && root.right == null) {
            sum += val;
            return;
        }
        if (root.left != null) {
            dfs(root.left, val);
        }
        if (root.right != null) {
            dfs(root.right, val);
        }
    }
}
