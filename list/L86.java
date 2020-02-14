/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyBefore = new ListNode(-1), dummyAfter = new ListNode(-1);
        ListNode before = dummyBefore, after = dummyAfter, cur = head;

        while (cur != null) {
            if (cur.val < x) {
                before.next = cur;
                before = cur;
                cur = cur.next;
            } else {
                after.next = cur;
                after = cur;
                cur = cur.next;
            }
        }

        before.next = dummyAfter.next;
        after.next = null;
        
        return dummyBefore.next;
    }
}
