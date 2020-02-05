/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Node cur = root;
        while (cur != null) {
            Node down = null, pre = null;
            while (cur != null) {
                if (cur.left == null && cur.right == null) {
                    cur = cur.next;
                    continue;
                }
                // 连接左右
                if (cur.left != null && cur.right != null) cur.left.next = cur.right;
                // 连接前后
                if (pre != null) pre.next = cur.left != null ? cur.left : cur.right;
                // 设置pre
                pre = cur.right != null ? cur.right : cur.left;
                // 设置下一行节点
                if (down == null) down = cur.left != null ? cur.left : cur.right;
                cur = cur.next;
            }
            cur = down;
        }

        return root;
    }
}
