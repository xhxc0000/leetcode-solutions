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
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (i > 0) pre.next = cur;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);

                pre = cur;
            }
        }

        return root;
    }
    
    // O(1)空间
    public Node connect(Node root) {
        if (root == null) return root;
        Node cur = root;
        while (cur.left != null) {
            Node down = cur.left, pre = null;
            while (cur != null) {
                cur.left.next = cur.right;
                if (pre != null) pre.next = cur.left;
                pre = cur.right;
                cur = cur.next;
            }
            cur = down;
        }

        return root;
    }
}
