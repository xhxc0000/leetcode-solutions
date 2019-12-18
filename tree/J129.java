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

    private int res = 0;
    private long path = 0;
    public int sumNumbers(TreeNode root) {
        if (root != null) dfs(root);

        return res;
    }

    private void dfs(TreeNode root) {
        // store scene
        path = path * 10 + root.val;
        if (root.left != null) dfs(root.left);
        if (root.right != null) dfs(root.right);
        if (root.left == null && root.right == null) res += path;

        //restore scene
        path /= 10;
    }
}
