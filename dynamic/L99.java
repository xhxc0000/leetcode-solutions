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

    private List<TreeNode> list = new ArrayList<>();
       // O(1)空间
       public void recoverTree(TreeNode root) {
        TreeNode pre = null, cur = root, first = null, second = null;
        while (cur != null) {
            if (cur.left == null) {
                if (pre != null && pre.val > cur.val) {
                    if (first == null) {
                        first = pre;
                        second = cur;
                    } else {
                        second = cur;
                    }
                }
                pre = cur; // 表示已保存
                cur = cur.right;
            } else {
                TreeNode p = cur.left;
                while (p.right != null && p.right != cur) p = p.right;
                if (p.right == null) {
                    p.right = cur;
                    cur = cur.left;
                } else {
                    // 已访问过, 则保存cur，迭代右子树
                    p.right = null; // 恢复原树
                    if (pre != null && pre.val > cur.val) {
                        if (first == null) {
                            first = pre;
                            second = cur;
                        } else {
                            second = cur;
                        }
                    }
                    pre = cur;
                    cur = cur.right;
                }
            }
        }

        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }




    // O(N)空间
    public void recoverTree(TreeNode root) {
        dfs(root);

        int l = 0, r = list.size() - 1;
        while (l + 1 < list.size()) {
            if (list.get(l).val > list.get(l + 1).val) break;
            l++;
        }
        while (r > 0) {
            if (list.get(r - 1).val > list.get(r).val) break;
            r--;
        }
        int tmp = list.get(l).val;
        list.get(l).val = list.get(r).val;
        list.get(r).val = tmp;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        list.add(root);
        dfs(root.right);
    }
}
