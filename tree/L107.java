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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> line = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode p = q.poll();
                line.add(p.val);

                if (p.left != null) q.offer(p.left);
                if (p.right != null) q.offer(p.right);
            }

            res.addFirst(line);
        }

        return res;
    }
}
