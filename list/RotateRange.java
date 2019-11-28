public class RotateRange {
  public static void main(String[] args) {
    ListNode head = ListNodeUtil.generateListNode(new int[] {1,2,3,4,5});
    head = rotateRange(head, 2,4);
    ListNodeUtil.print(head);
  }

  private static ListNode rotateRange(ListNode head, int m, int n) {
    if (head == null || m == n) return head;
    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    // locate a c. b d
    ListNode a = dummy, b = null, d = dummy, c = null;
    for (int i = 0; i < m - 1; i++) a = a.next;
    b = a.next;
    for (int i = 0; i < n; i++) d = d.next;
    c = d.next;
    // reverse b to d
    ListNode pre = a, curr = b;
    while (curr != c) {
        ListNode next = curr.next;
        curr.next = pre;
        pre = curr;
        curr = next;
    }

    // connection
    a.next = pre;
    b.next = c;

    return dummy.next;
  }
}
