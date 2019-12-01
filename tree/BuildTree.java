import java.util.*;

public class BuildTree {
  public static void main(String[] args) {
    int[] pre = new int[] {3,9,20,15,7};
    int[] in = new int[] {9,3,15,20,7};
    buildTree(pre, in);
  }

  // val -> index
  static Map<Integer, Integer> indexMap = new HashMap<>();

  private static TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;

    for (int i = 0; i < inorder.length; i++) {
        indexMap.put(inorder[i], i);
    }

    return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
  }

  private static TreeNode buildTree(int[] pre,
  int[] in, int preL, int preR, int inL, int inR) {

   if (preL > preR) return null;
   TreeNode root = new TreeNode(pre[preL]);
   int index = indexMap.get(pre[preL]);
   int len = index - inL;

   root.left = buildTree(pre, in, preL + 1, preL + len, inL, index - 1);
   root.right = buildTree(pre, in, preL + len + 1, preR, index + 1, inR);

   return root;
  }
}
