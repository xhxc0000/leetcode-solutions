/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    // 表示cut出来的链表是否需要翻转
    private boolean needReverse = false;
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1), tail = dummy;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cut(cur, k);
            if (!needReverse) {
                tail.next = cur;
                break;
            } else {
                ListNode tmp = cur;
                tail.next = reverse(cur);
                tail = tmp;

                cur = next;
            }
        }

        return dummy.next;
    }

    private ListNode cut(ListNode head, int k) {
        k--;
        ListNode p = head;
        while (p != null && k > 0) {
            p = p.next;
            k--;
        }

        if (p == null) {
            needReverse = false;
            return null;
        } else {
            ListNode next = p.next;
            p.next = null;
            needReverse = true;

            return next;
        }
    } 

    private ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
