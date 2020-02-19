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
    private long pre = (long)Integer.MIN_VALUE - 1;
    public boolean isValidBST(TreeNode root) {
        return dfs(root);
    }

    private boolean dfs(TreeNode root) {
        if (root == null) return true;
        if (!dfs(root.left)) return false;

        if (pre >= root.val) return false;
        pre = root.val;

        if (!dfs(root.right)) return false;

        return true;
    }
   
}
