/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 import java.util.*;
class Solution {

    private List<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        iterate(root);

        return res;
    }

    private void iterate(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                res.add(p.val);
                stack.push(p);
                p = p.right;
            }
            p = stack.pop();
            p = p.left;
        }

        int L = 0, R = res.size() - 1;
        while (L < R) {
            int tmp = res.get(L);
            res.set(L++, res.get(R));
            res.set(R--, tmp);
        }
    }

    private void recurse(TreeNode root) {
        if (root == null) return;

        recurse(root.left);
        recurse(root.right);
        res.add(root.val);
    }
}
