/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    
    
    public TreeNode buildTree(int[] pre, int[] in) {
        if (pre.length < 1) return null;
        
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        
        return dfs(pre, 0, pre.length - 1, 0);
    }
    
    private TreeNode dfs(int[] pre, int preL, int preR, int inL) {
        if (preL <= preR) {
            TreeNode root = new TreeNode(pre[preL]);
            int index = map.get(root.val);
            int len = index - inL;
            
            root.left = dfs(pre, preL + 1, preL + len, inL);
            root.right = dfs(pre, preL + len + 1, preR, index + 1);    
            
            return root;
        }
        
        
        return null;
    }
}
