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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);

        return dfs(inorder, postorder, 0, postorder.length - 1, 0);
    }

    private TreeNode dfs(int[] in, int[] post, int postL, int postR, int inL) {
        if (postL > postR) return null;
        if (postL == postR) return new TreeNode(post[postR]);
        TreeNode res = new TreeNode(post[postR]);
        int index = map.get(res.val);
        int count = index - inL;

        res.right = dfs(in, post, postL + count, postR - 1, index + 1);
        res.left = dfs(in, post, postL, postL + count - 1, inL);

        return res;
    }
}
