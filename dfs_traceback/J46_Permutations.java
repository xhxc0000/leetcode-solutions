import java.util.*;

public class J46_Permutations {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3};
    List<List<Integer>> res = permute(arr);
    for (List<Integer> list : res) {
      for (int i : list) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }

  private static List<List<Integer>> res = new ArrayList<>();

  private static List<Integer> ret = new ArrayList<>();

  private static boolean[] visited;

  // 数字不重复,根据每位,枚举未访问过的数字
  public static List<List<Integer>> permute(int[] arr) {
    if (arr.length < 1) return res;
    visited = new boolean[arr.length];
    dfs(arr, 0);

    return res;
  }



  private static void dfs(int[] arr, int index) {
    // case add ret
    if (index == arr.length) {
      res.add(new ArrayList<>(ret));
      return;
    }

    // case permute non-visited
    for (int i = 0; i < arr.length; i++) {
      if (!visited[i]) {
        // store scene
        visited[i] = true;
        ret.add(arr[i]);
        dfs(arr, index + 1);
        //restore scene
        visited[i] = false;
        ret.remove(ret.size() - 1);
      }
    }
  }
}
