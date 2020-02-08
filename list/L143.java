/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    // 思路1.存储
    public void reorderList(ListNode head) {
        if (head == null) return;
        List<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p);
            p = p.next;
        }
        
        int l = 0, r = list.size() - 1;
        while (l < r) {
            list.get(l).next = list.get(r);
            l++;
            if (l == r) break;
            list.get(r).next = list.get(l);
            r--;
        }
        list.get(l).next = null;
    }
    

    // 原地调整
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 奇数 fast 非空，slow 恰在中间
        // 偶数 fast 空， slow偏右
        ListNode p = head, q = reverse(slow.next);
        slow.next = null;
        while (q != null) {
            ListNode qNext = q.next;
            q.next = p.next;
            p.next = q;
            p = q.next;
            q = qNext;
        }

    }

    private ListNode reverse(ListNode head) {
        ListNode cur = head, newHead = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }

        return newHead;
    }
}
