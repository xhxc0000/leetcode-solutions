/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplication(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            if (cur.val == next.val) {
                while (next != null && cur.val == next.val) {
                    next = next.next;
                }
                pre.next = next;
                cur = pre.next;
            } else {
                pre = cur;
                cur = pre.next;
            }
        }
        
        return dummy.next;
    }
}
