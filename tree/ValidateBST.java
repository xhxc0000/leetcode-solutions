public class ValidateBST {
  public static void main(String[] args) {
    System.out.println(Integer.MIN_VALUE);
  }

  private static boolean isValidBST(TreeNode root) {
    if (root == null) return true;
    return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private static boolean dfs(TreeNode root, long minv, long maxv) {
    if (root == null) return true;
    if (root.val < minv || root.val > maxv) return false;
    return dfs(root.left, minv, (long)root.val - 1)
    && dfs(root.right, (long)root.val + 1, maxv);
  }
}
