/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 import java.util.*;
class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null) return res;

        TreeNode p = root;
        LinkedList<TreeNode> queue = new LinkedList<>();
        int cur = 1, next = 0;
        queue.offer(p);
        while (!queue.isEmpty()) {
            p = queue.poll();
            path.add(p.val);
            cur--;
            if (p.left != null) {
                queue.offer(p.left);
                next++;
            }
            if (p.right != null) {
                queue.offer(p.right);
                next++;
            }

            // add res
            if (cur == 0) {
                cur = next;
                next = 0;
                res.add(path);
                path = new ArrayList<>();
            }
        }

        Collections.reverse(res);
        return res;
    }
}
