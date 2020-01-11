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
    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null || root1 == null) return false;
        
        if (root1.val == root2.val && equal(root1, root2)) {
           return true;
        } else {
            return hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
        }
    }
    
    
    private boolean equal(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        
        return root1.val == root2.val && equal(root1.left, root2.left) && equal(root1.right, root2.right);
    }
}
