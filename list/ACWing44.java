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
    public List<List<Integer>> printFromTopToBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null) return res;
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        int cur = 1, next = 0;
        TreeNode p = root;
        queue.offer(p);
        
        while (!queue.isEmpty()) {
            p = queue.poll();
            cur--;
            path.add(p.val);
            
            if (p.left != null) {
                next++;
                queue.offer(p.left);
            }
            if (p.right != null) {
                next++;
                queue.offer(p.right);
            }
            
            if (cur == 0) {
                res.add(path);
                path = new ArrayList<>();
                cur = next;
                next = 0;
            }
        }
        
        return res;
    }
}
