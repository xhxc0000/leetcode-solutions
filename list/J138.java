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
        if (head == null) return head;
        // copy
        Node newHead;
        Node p = head;
        
        while (p != null) {
            Node next = p.next;
            Node neww = new Node(p.val);
            p.next = neww;
            neww.next = next;
            p = next;
        }
        newHead = head.next;
        
        // copy random
        Node old = head;
        while (old != null && old.next != null) {
            Node neww = old.next;
            if (old.random != null) {
                neww.random = old.random.next;
            } else {
                neww.random = null;
            }
            old = neww.next;
        }
        // separate
        old = head;
        while (old != null && old.next != null) {
            Node neww = old.next;
            old.next = neww.next;
            old = neww;
        }
        
        return newHead;
    }
}
