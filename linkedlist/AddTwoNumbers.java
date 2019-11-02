public class AddTwoNumbers {
  public static void main(String[] args) {
    int[] l1 = {9,9};
    int[] l2 = {1};
    ListNode head = addTwoNumbers(ListNodeUtil.generateListNode(l1), ListNodeUtil.generateListNode(l2));
    ListNodeUtil.print(head);

  }

  // (2 -> 4 -> 3) + (5 -> 6 -> 4) -> 7 -> 0 -> 8
  private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int[] res = add(l1.val, l2.val, 0);
    int carry = res[1];
    ListNode retVal = new ListNode(res[0]);
    ListNode curr = retVal;
    l1 = l1.next;
    l2 = l2.next;
    while (l1 != null && l2 != null) {
      res = add(l1.val, l2.val, carry);
      curr.next = new ListNode(res[0]);
      curr = curr.next;
      carry = res[1];

      l1 = l1.next;
      l2 = l2.next;
    }
    while (l1 != null) {
      res = add(l1.val, carry, 0);
      curr.next = new ListNode(res[0]);
      curr = curr.next;
      l1 = l1.next;
      carry = res[1];
    }
    while (l2 != null) {
      res = add(l2.val, carry, 0);
      curr.next = new ListNode(res[0]);
      curr = curr.next;
      l2 = l2.next;
      carry = res[1];
    }
    if (carry == 1) {
      curr.next = new ListNode(1);
    }

    return retVal;
  }

  // 因为保证链表非空, 可以直接返回root.next
  public static ListNode betterResolution(ListNode l1, ListNode l2) {
    ListNode root = new ListNode(0);
    ListNode pointer = root;
    int carry = 0;

    while (l1 != null || l2 != null || carry != 0) {
      int v1 = l1 == null ? 0 : l1.val;
      int v2 = l2 == null ? 0 : l2.val;

      int sum = v1 + v2 + carry;
      carry = sum / 10;
      pointer.next = new ListNode(sum % 10);
      pointer = pointer.next;

      l1 = l1 == null ? null : l1.next;
      l2 = l2 == null ? null : l2.next;
    }

    return root.next;
  }

  // retVal[0] -> 相加后的个位数, retVal[1] 进位
  private static int[] add(int v1, int v2, int v3) {
    int sum = v1 + v2 + v3;

    return new int[] {sum % 10, sum / 10};
  }
}
