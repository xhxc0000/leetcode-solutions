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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                res.add(p.val);
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            p = p.right;
        }

        return res;
    }
}
