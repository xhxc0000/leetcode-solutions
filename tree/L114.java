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
    // 思路1 非遍历版修改, 迭代
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode tmp = cur.right;
                cur.right = cur.left;
                cur.left = null;
                TreeNode p = cur.right;
                while (p.right != null) p = p.right;
                p.right = tmp;

                cur = cur.right;
            } else {
                cur = cur.right;
            }
        }
    }

    // 递归遍历版
    private TreeNode pre;
    public void flatten(TreeNode root) {
        if (root == null) return;
        if (pre == null) {
            pre = root;
        } else {
            pre.left = null;
            pre.right = root;
            pre = root;
        }
        TreeNode right = root.right;
      
        flatten(root.left);
        flatten(right);
    }


}
