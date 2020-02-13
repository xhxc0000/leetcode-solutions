/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = head, pre = dummy;

        while (cur != null) {
            while (cur != null && cur.val == val) cur = cur.next;
            pre.next = cur;
            if (cur == null) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }

        return dummy.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy, cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val != val) {
                cur.next = null;
                p.next = cur;
                p = cur;
            }
            cur = next;
        }

        return dummy.next;
    }
}
