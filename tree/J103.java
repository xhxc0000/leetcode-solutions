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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null) return res;
        boolean left2Right = true;
        LinkedList<TreeNode> dequeue = new LinkedList<>();
        dequeue.offer(root);
        int cur = 1, next = 0;

        while(!dequeue.isEmpty()) {
            if (left2Right) {
                TreeNode p = dequeue.poll();
                path.add(p.val);
                cur--;
                if (p.left != null) {
                    dequeue.offer(p.left);
                    next++;
                }
                if (p.right != null) {
                    dequeue.offer(p.right);
                    next++;
                }
            } else {
                // right to left
                TreeNode p = dequeue.pollLast();
                path.add(p.val);
                cur--;
                if (p.right != null) {
                    dequeue.offerFirst(p.right);
                    next++;
                }
                if (p.left != null) {
                    dequeue.offerFirst(p.left);
                    next++;
                }
            }
            if (cur == 0) {
                left2Right = !left2Right;
                cur = next;
                next = 0;
                res.add(path);
                path = new ArrayList<>();
            }
        }

        return res;
    }
}
