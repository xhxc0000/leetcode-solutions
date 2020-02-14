/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // copy node
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }

        // copy random
        cur = head;
        while (cur != null) {
            Node random = cur.random;
            cur.next.random = random == null ? null : random.next;
            cur = cur.next.next;
        }

        // split 
        Node dummy = new Node(-1), copy = dummy;
        cur = head;
        while (cur != null) {
            copy.next = cur.next;
            copy = copy.next;
            cur.next = cur.next.next;
            cur = cur.next;
        }

        return dummy.next;
    }
}
