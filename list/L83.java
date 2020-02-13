/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy, cur = head;

        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) cur = cur.next;
            pre.next = cur;
            pre = cur;
            cur = cur.next;
        }

        return dummy.next;
    }
}
