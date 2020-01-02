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

    // 迭代解法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> left = new ArrayList<>(), right = new ArrayList<>();
       
        
        dfs(left, root, p);
        dfs(right, root, q);
        left.add(root);
        right.add(root);
        // find last public node
        
        int l = left.size() - 1, r = right.size() - 1;
        TreeNode pre = left.get(l);
        
        // for (TreeNode val : left) System.out.print(val.val + " ");
        // System.out.println();
        // for (TreeNode val : right) System.out.print(val.val + " ");
       
        while (true) {
            if (l < 0 || r < 0 || left.get(l) != right.get(r)) return pre;
            pre = left.get(l);
            l--; r--;
        }
    }

     private boolean dfs(List<TreeNode> path, TreeNode root, TreeNode target) {
        if (root == null) return false;
        if (root == target) return true;
        
        boolean left = dfs(path, root.left, target);
        boolean right = dfs(path, root.right, target);
        if (left) path.add(root.left);
        if (right) path.add(root.right);
        
        return left || right;
    }


    // 递归解法
     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }


}
