/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] printListReversingly(ListNode head) {
        int size = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            size++;
        }
        head.next = null;
        head = pre;
        
        
        int[] res = new int[size];
        ListNode p = head;
        for (int i = 0; i < res.length; i++) {
            res[i] = p.val;
            p = p.next;
        }
        
        return res;
    }
}
