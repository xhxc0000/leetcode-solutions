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

    private TreeNode dfs(int[] arr, int l, int r) {
        if (l > r) return null;
        if (l == r) return new TreeNode(arr[l]);
        int mid = l + r >>> 1;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = dfs(arr, l, mid - 1);
        root.right = dfs(arr, mid + 1, r);

        return root;
    }
}
