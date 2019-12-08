import java.util.*;
public class J78_Subsets {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3};
    List<List<Integer>> res = iteration(arr);
    for (List<Integer> list : res) {
      for (int i : list) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }

  private static List<List<Integer>> res = new ArrayList<>();

  private static List<Integer> path = new ArrayList<>();



  // i的二进制表示中第j位是否为0:   i >> j & 1
  public static List<List<Integer>> iteration(int[] arr) {
    for (int i = 0; i < 1 << arr.length; i++) {
      List<Integer> now = new ArrayList<>();
      for (int j = 0; j < arr.length; j++) {
        if ((i >> j & 1) == 1) now.add(arr[j]);
      }
      res.add(now);
    }

    return res;
  }

  public static List<List<Integer>> subsets(int[] arr) {
    dfs(arr, 0);

    return res;
  }

  private static void dfs(int[] arr, int index) {
    if (index == arr.length) {
      res.add(new ArrayList<>(path));
      return;
    }

    path.add(arr[index]);
    dfs(arr, index + 1);
    path.remove(path.size() - 1);
    dfs(arr, index + 1);
  }
}
