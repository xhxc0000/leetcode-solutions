/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        int size = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            size++;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = null, tail = null;
        for (int i = 1; i < size; i *= 2) {
            cur = dummy.next; tail = dummy;
            while (cur != null) {
                ListNode left = cur;
                ListNode right = cut(left, i);
                cur = cut(right, i);
                // connect
                tail.next = merge(left, right);
                while (tail.next != null) tail = tail.next;
            }
        }
        
        return dummy.next;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
                p = p.next;
            } else {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            }
        }
        p.next = l1 != null ? l1 : l2;

        return dummy.next;
    }

    // 返回切断前n个节点之后的链表头
    private ListNode cut(ListNode head, int n) {
        ListNode p = head;
        while (p != null && n > 1) {
            n--;
            p = p.next;
        }
        if (p == null) return null;
        ListNode next = p.next;
        p.next = null;
        
        return next;
    }
}
