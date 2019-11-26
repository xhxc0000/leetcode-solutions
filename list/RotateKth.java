public class RotateKth {
  public static void main(String[] args) {
    ListNode head = ListNodeUtil.generateListNode(new int[] {1, 2, 3, 4, 5});
    head = rotateRight(head, 2);
    ListNodeUtil.print(head);
  }


  private static ListNode rotateRight(ListNode head, int k) {
    if (head == null) return head;
    ListNode fir = head;

    // get length
    int cnt = 0;
    while (fir != null) {
      fir = fir.next;
      cnt += 1;
    }

    // locate tail and k
    k = k % cnt;
    fir = head;
    while (k-- > 0) {
      fir = fir.next;
    }

    ListNode sec = head;
    while (fir.next != null) {
      fir = fir.next;
      sec  =sec.next;
    }

    // change pointer
    fir.next = head;
    head = sec.next;
    sec.next = null;

    return head;
  }
}
