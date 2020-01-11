/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode father;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode p) {
        if (p.right != null) {
            p = p.right;
            while (p.left != null) p = p.left;
            return p;
        } else if (p.father == null) {
            return null;
        } else if (p.father.left == p) {
            return p.father;
        } else {
            while (p.father != null && p.father.left != p) p = p.father;
            return p.father;
        }
    }
}
