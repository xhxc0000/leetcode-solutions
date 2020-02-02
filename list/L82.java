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
        ListNode cur = head, pre = dummy;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            if (cur.val == next.val) {
                while (next != null && next.val == cur.val) next = next.next;
                cur = next;
            } else {
                pre.next = cur;
                pre = pre.next;
                cur = next;
            }
        }
        if (cur != null) pre.next = cur;
        else pre.next = null;

        return dummy.next;
    }
}
