/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode p = root;
        int size = 0;
        while (p != null) {
            p = p.next;
            size++;
        }

        ListNode[] arr = new ListNode[k];
        int avg = size / k, surplus = size % k;
        ListNode cur = root;
        for (int i = 0; i < k; i++) {
            if (surplus > 0) {
                ListNode next = cut(cur, avg + 1);
                surplus--;
                arr[i] = cur;
                cur = next;
            } else {
                ListNode next = cut(cur, avg);
                arr[i] = cur;
                cur = next;
            }
        }

        return arr;
    }


    private ListNode cut(ListNode head, int k) {
        k--;
        ListNode p = head;
        while (p != null && k > 0) {
            p = p.next;
            k--;
        }

        if (p != null) {
            ListNode next = p.next;
            p.next = null;
            return next;
        }

        return null;
    }
}
