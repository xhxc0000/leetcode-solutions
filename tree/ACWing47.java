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
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    
    public List<List<Integer>> findPath(TreeNode root, int sum) {
        if (root == null) return res;
        dfs(root, sum);
        return res;
    }
    
    private void dfs(TreeNode root, int remain) {
        // enumerate
        // store
        path.add(root.val);
        remain -= root.val;
        if (root.left != null) dfs(root.left, remain);
        if (root.right != null) dfs(root.right, remain);
        if (root.left == null && root.right == null && remain == 0) res.add(new ArrayList<>(path));
        // restore
        path.remove(path.size() - 1);
    }
}
