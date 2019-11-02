public class ListNodeUtil {
    private ListNodeUtil() {}


    public static ListNode generateListNode(int[] arr) {
      ListNode retVal = new ListNode(arr[0]);
      ListNode curr = retVal;

      for (int i = 1; i < arr.length; i++) {
        curr.next = new ListNode(arr[i]);
        curr = curr.next;
      }

      return retVal;
    }

    public static void print(ListNode head) {
      while (head != null) {
        System.out.print(head.val + " ");
        head = head.next;
      }
    }
}
