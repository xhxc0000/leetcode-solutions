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
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return res;
        dfs(root);

        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        int len = path.length();
        path.append(root.val).append("->");
        if (root.left == null && root.right == null) {
            res.add(path.substring(0, path.length() - 2));
        }


        dfs(root.left);
        dfs(root.right);

        path.setLength(len);
    }
}
