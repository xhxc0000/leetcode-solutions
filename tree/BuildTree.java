import java.util.*;

public class BuildTree {
  public static void main(String[] args) {
    int[] pre = new int[] {3,9,20,15,7};
    int[] in = new int[] {9,3,15,20,7};
    buildTree(pre, in);
  }

  // val -> index
  static Map<Integer, Integer> map = new HashMap<>();

  private static TreeNode buildTree(int[] preorder, int[] inorder) {
    for (int i = 0; i < inorder.length; i++) {
      map.put(i, inorder[i]);
    }

    return buildTree(preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1);
  }

  private static TreeNode buildTree(int[] preorder,
  int[] inorder, int preL, int preR, int inL, int inR) {
    TreeNode root = new TreeNode(preorder[preL]);
    int index = map.get(preorder[preL]);
    int len = index - inL;
    root.left = buildTree(preorder, inorder, preL + 1, preL + len, inL, index - 1);
    root.right = buildTree(preorder, inorder, preL + len + 1, preR, index + 1, inR);

    return root;
  }
}
