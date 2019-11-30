import java.util.*;
public class Traversal {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

  }

  private static List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> stk = new Stack<>();
    TreeNode p = root;
    while (p != null || !stk.isEmpty()) {
      while (p != null) {
        stk.push(p);
        p = p.left;
      }
      p = stk.pop();
      res.add(p.val);
      p = p.right;
    }

    return res;
  }
}
