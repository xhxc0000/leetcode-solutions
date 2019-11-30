import java.util.*;
public class IsSymmetric {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);
    System.out.println(isSymmetric(root));
  }

  private static boolean isSymmetric(TreeNode root) {
    Stack<TreeNode> stkL = new Stack<>();
    Stack<TreeNode> stkR = new Stack<>();
    TreeNode L = root, R = root;

    while (L != null || R != null || !stkL.isEmpty() || !stkR.isEmpty()) {
      while (L != null && R != null) {
        stkL.push(L); stkR.push(R);
        L = L.left; R = R.right;
      }
      if (L != null || R != null) return false;
      L = stkL.pop(); R = stkR.pop();
      if (L.val != R.val) return false;

      L = L.right; R = R.left;
    }

    return true;
  }
}
