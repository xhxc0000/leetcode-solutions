/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        // dummy.next = head;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next, p = dummy;
            while (p.next != null && p.next.val <= cur.val) p = p.next;
            cur.next = p.next;
            p.next = cur;

            cur = next;
        }

        return dummy.next;
    }

    // 根据题意优化
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        // dummy.next = head;
        ListNode cur = head, tail = dummy;
        while (cur != null) {
            if (cur.val > tail.val) {
                tail.next = cur;
                tail = cur;
                cur = cur.next;
            } else {
                ListNode next = cur.next, p = dummy;
                while (p.next != null && p.next.val < cur.val) p = p.next;
                cur.next = p.next;
                p.next = cur;
                cur = next;
            }
        }
        tail.next = null;

        return dummy.next;
    }
}
