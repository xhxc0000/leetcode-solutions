/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy, pre = dummy;
        for (int i = 0; i < m; i++) {
            pre = cur;
            cur = cur.next;
        }
        ListNode tail = pre, midTail = cur;
        pre = null;
        for (int i = 0; i <= n - m; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // pre = midHead
        tail.next = pre;
        midTail.next = cur;

        return dummy.next;
    }
}
