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
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return res;

        dfs(root, sum);

        return res;
    }

    private void dfs(TreeNode root, int remain) {
        if (root == null) {
            return;
        }
        remain -= root.val;
        path.add(root.val);
        if (root.left == null && root.right == null && remain == 0) {
            res.add(new ArrayList<>(path));
        }

        dfs(root.left, remain);
        dfs(root.right, remain);
        path.removeLast();
    }
}
