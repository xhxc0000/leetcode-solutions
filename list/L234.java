/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }

        p = head;
        while (p != null) {
            if (p.val != stack.pop()) return false;
            p = p.next;
        }
        return true;
    }

	// O(1)空间
	public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) slow = slow.next;
        fast = head;
        slow = reverse(slow);
        while (slow != null) {
            if (slow.val != fast.val) return false;

            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }
}
