import java.util.*;

public class SerializeAndDeserialize {
  public static void main(String[] args) {
    String s = "1_2_#_#_3_#_#_";
    TreeNode root = new SerializeAndDeserialize().deSerialize(s);
    System.out.println(new SerializeAndDeserialize().serialize(root));
  }


  public String serialize(TreeNode root) {
    return preSerialize(root, new StringBuilder()).toString();
  }

  public TreeNode deSerialize(String serial) {
    String[] nodes = serial.split("_");
    Queue<String> queue = new LinkedList<>();
    for (String s : nodes) {
      queue.offer(s);
    }

    return preDeserialize(queue);
  }

  private TreeNode preDeserialize(Queue<String> queue) {
    String val = queue.poll();
    if (val.equals("#")) {
      return null;
    }

    TreeNode ret = new TreeNode(Integer.valueOf(val));
    ret.left = preDeserialize(queue);
    ret.right  =preDeserialize(queue);

    return ret;
  }


  private StringBuilder preSerialize(TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append("#_");
      return sb;
    }

    sb.append(root.val).append("_");
    sb = preSerialize(root.left, sb);
    sb = preSerialize(root.right, sb);
    return sb;
  }

  private static void preScan(TreeNode root) {
    if (root == null) {
      System.out.print("null ");
      return;
    }
    System.out.print(root.val + " ");
    preScan(root.left);
    preScan(root.right);
  }
}
