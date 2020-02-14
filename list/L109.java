/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return dfs(head, null);
    }

    private TreeNode dfs(ListNode start, ListNode end) {
        if (start == end) return null;
        if (start.next == end) return new TreeNode(start.val);

        ListNode slow = start, fast = start;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = dfs(start, slow);
        root.right = dfs(slow.next, end);

        return root;
    } 
}
