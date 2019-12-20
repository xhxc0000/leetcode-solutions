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
    public int pathSum(TreeNode root, int sum) {
        this.target = sum;
        map.put(0, 1);

        return dfs(root, 0);
    }

    // sum -> count
    private Map<Integer, Integer> map = new HashMap<>();
    private int target;

    private int dfs(TreeNode root, int pathSum) {
        if (root == null) return 0;
        int res = 0;

        // store scene
        pathSum += root.val;
        res += map.getOrDefault(pathSum - target, 0);
        map.put(pathSum, map.getOrDefault(pathSum, 0) + 1);
        res = dfs(root.left, pathSum) + dfs(root.right, pathSum) + res;
        // restore scene
        map.put(pathSum, map.get(pathSum) - 1);

        return res;
    }
}
