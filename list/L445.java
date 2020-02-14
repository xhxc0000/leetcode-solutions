/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        l1 = reverse(l1);
        l2 = reverse(l2);

        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            pre.next = new ListNode(sum % 10);
            carry = sum / 10;
            pre = pre.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            pre.next = new ListNode(sum % 10);
            pre = pre.next;
            carry = sum / 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            pre.next = new ListNode(sum % 10);
            pre = pre.next;
            carry = sum / 10;
            l2 = l2.next;
        }
        if (carry == 1) pre.next = new ListNode(1);

        return reverse(dummy.next);
    }

}
