/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode p = head;
        int size = 0;
        while (p != null) {
            p = p.next;
            size++;
        }
        if (head == null || k % size == 0) return head;
        dummy.next = reverse(head);

        ListNode tail = dummy, newHead = null;
        for (int i = 0; i < k % size; i++) tail = tail.next;
        
        newHead = tail.next;
        tail.next = null;
        tail = dummy.next;
        

        dummy.next = reverse(tail);
        
        tail.next = reverse(newHead);

        return dummy.next;

    }

	// 思路2
	public ListNode rotateRight(ListNode head, int k) {
        int size = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            size++;
        }
        if (head == null || k % size == 0) return head;
        k %= size;

        // 此时保证k在 [1, size - 1] 范围内
        ListNode tail = head, newHead = null;
        for (int i = 1; i < size - k; i++) tail = tail.next;
        newHead = tail.next;
        tail.next = null;
        
        tail = newHead;
        while (tail.next != null) tail = tail.next;
        tail.next = head;

        return newHead;
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
