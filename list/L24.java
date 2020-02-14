/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy, one = head;

        while (one != null && one.next != null) {
            ListNode two = one.next, next = two.next;
            pre.next = two;
            two.next = one;
            pre = one;
            one = next;
        }

        pre.next = one;

        return dummy.next;
    }
}
