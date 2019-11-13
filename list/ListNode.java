public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
            val = x;
    }


    public static ListNode transform(int[] arr) {
      ListNode header = new ListNode(-1);
      if (arr == null || arr.length < 1) return null;

      ListNode curr = header;
      for (int i : arr) {
        curr.next = new ListNode(i);
        curr = curr.next;
      }

      return header.next;
    }


    public static void print(ListNode header) {
      while (header != null) {
        System.out.print(header.val + " ");
        header = header.next;

      }
    }
}
