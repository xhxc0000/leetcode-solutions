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
    // val -> index
    private Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);

        return dfs(preorder, 0, preorder.length - 1, 0);
    }

    private TreeNode dfs(int[] pre, int preL, int preR, int inL) {
        if (preL > preR) return null;
        if (preL == preR) return new TreeNode(pre[preL]);

        TreeNode root = new TreeNode(pre[preL]);
        int index = map.get(pre[preL]);
        int length = index - inL;

        root.left = dfs(pre, preL + 1, preL + length, inL);
        root.right = dfs(pre, preL + length + 1, preR, index + 1);

        return root;
    }
}
