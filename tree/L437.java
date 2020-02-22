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

    // pathSum -> count
    private Map<Integer, Integer> map = new HashMap<>();

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        map.put(0, 1);
        
        return dfs(root, 0, sum);
    }

    private int dfs(TreeNode root, int pathSum, final int target) {
        if (root == null) return 0;
        int res = 0;
        // store
        pathSum += root.val;
        res += map.getOrDefault(pathSum - target, 0);
        map.put(pathSum, map.getOrDefault(pathSum, 0) + 1);

        res += dfs(root.left, pathSum, target) + dfs(root.right, pathSum, target);

        // restore
        map.put(pathSum, map.get(pathSum) - 1);

        return res;
    }
}
