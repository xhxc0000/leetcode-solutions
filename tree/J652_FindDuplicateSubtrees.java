import java.util.*;
public class J652_FindDuplicateSubtrees {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(2);
    root.right.left.left = new TreeNode(4);
    List<TreeNode> list = findDuplicateSubtrees(root);
    for (TreeNode p : list) {
      System.out.println(p.val);
    }
  }

  private static List<TreeNode> res = new ArrayList<>();

  private static Map<String, Integer> map = new HashMap<>();

  public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    dfs(root);
    return res;
  }


  private static String dfs(TreeNode root) {
    if (root == null) return "#!";
    String serl = root.val + "!" + dfs1(root.left) + dfs1(root.right);
    int count = map.getOrDefault(serl, 0) + 1;
    map.put(serl, count);
    if (count == 2) res.add(root);

    return serl;
  }
}
