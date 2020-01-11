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
        if (root == null) return res;
        
        
        List<Integer> path = new ArrayList<>();
        boolean left2Right = true;
        LinkedList<TreeNode> deq = new LinkedList<>();
        deq.offer(root);
        int cur = 1, next = 0;
        
        while (!deq.isEmpty()) {
            if (left2Right) {
                TreeNode p = deq.poll();
                path.add(p.val);
                cur--;
                if (p.left != null) {
                    deq.offer(p.left);
                    next++;
                }
                if (p.right != null) {
                    deq.offer(p.right);
                    next++;
                }
                
            } else {
                TreeNode p = deq.pollLast();
                path.add(p.val);
                cur--;
                if (p.right != null) {
                    deq.offerFirst(p.right);
                    next++;
                }
                if (p.left != null) {
                    deq.offerFirst(p.left);
                    next++;
                }
            }
            
            if (cur == 0) {
                res.add(path);
                path = new ArrayList<>();
                cur = next;
                next = 0;
                left2Right = !left2Right;
            }
        }
        
        return res;
    }
}
