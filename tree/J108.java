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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length < 1) return null;

        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] arr, int L, int R) {
        if (L > R) return null;
        int pivot = L + R >>> 1;
        TreeNode res = new TreeNode(arr[pivot]);
        res.left = dfs(arr, L, pivot - 1);
        res.right = dfs(arr, pivot + 1, R);

        return res;
    }
}
