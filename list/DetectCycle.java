public class DetectCycle {
  public static void main(String[] args) {
    ListNode head = ListNodeUtil.generateListNode(new int[] {3,2,0,-4});
    ListNode tail = head.next.next.next;
    tail.next = head.next;
    System.out.println(detectCycle(head).val);
  }

  private static ListNode detectCycle(ListNode head) {
    ListNode fast = head, slow = head;
      while (fast != null && fast.next != null) {
          fast = fast.next.next;
          slow = slow.next;
          if (fast == slow) break;
      }
      if (fast == null || fast.next == null) return null;
      fast = head;
      while (fast != slow) {
          fast = fast.next;
          slow = slow.next;
      }

      return fast;
  }
}
