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
        if (root == null) return res;

        Deque<TreeNode> deq = new LinkedList<>();
        deq.offer(root);
        boolean leftToRight = true;
        while (!deq.isEmpty()) {
            int size = deq.size();
            List<Integer> line = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                if (leftToRight) {
                    TreeNode p = deq.pollFirst();
                    line.add(p.val);

                    if (p.left != null) deq.offerLast(p.left); 
                    if (p.right != null) deq.offerLast(p.right);
                } else {
                    TreeNode p = deq.pollLast();
                    line.add(p.val);

                    if (p.right != null) deq.offerFirst(p.right);
                    if (p.left != null) deq.offerFirst(p.left);
                }
            }

            res.add(line);
            leftToRight = !leftToRight;
        }


        return res;
    }
}
