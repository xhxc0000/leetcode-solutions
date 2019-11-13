public class MergeTwoList {
  public static void main(String[] args) {
    ListNode l1 = ListNode.transform(new int[] {1, 2, 4});
    ListNode l2 = ListNode.transform(new int[] {1, 3, 4});

    ListNode.print(mergeTwoLists(l1, l2));
  }

  private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode header = new ListNode(-1);
    ListNode curr = header;

    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        curr.next = new ListNode(l1.val);
        curr = curr.next;
        l1 = l1.next;
      } else {
        curr.next = new ListNode(l2.val);
        curr = curr.next;
        l2 = l2.next;
      }
    }

    if (l1 != null) {
      curr.next = l1;
    } else {
      curr.next = l2;
    }

    return header.next;
  }
}
