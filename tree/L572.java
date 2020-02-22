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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = s;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                if (dfs(p, t)) return true;

                stack.push(p);
                p = p.left;
            }
            p = stack.pop().right;
        }

        return false;
    }

    private boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        
        if (p == null || q == null) return false;

        return p.val == q.val 
        && dfs(p.left, q.left) 
        && dfs(p.right, q.right);
    }


}
