public class SwapPairs {
  public static void main(String[] args) {
    ListNode head = ListNode.transform(new int[] {1, 2, 3, 4});
    head = swapPairs(head);
    ListNode.print(head);
  }

  private static ListNode swapPairs(ListNode head) {
    ListNode help = new ListNode(-1);
    help.next = head;
    ListNode curr = head;
    ListNode pre = help;
    while (curr != null && curr.next != null) {
      pre.next = curr.next;
      ListNode next = curr.next;
      curr.next = next.next;
      next.next = curr;
      pre = curr;
      curr = curr.next;
    }

    return help.next;
  }
}
