import java.util.*;

public class J47_Permutations {
  public static void main(String[] args) {
    List<List<Integer>> res = permuteUnique(new int[] {0,0,0,1});
    for (List<Integer> list : res) {
      for (int i : list) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }

  private static List<List<Integer>> res = new ArrayList<>();

  private static LinkedList<Integer> path = new LinkedList<>();

  private static boolean[] visited;

  public static List<List<Integer>> permuteUnique(int[] arr) {
    visited = new boolean[arr.length];
    Arrays.sort(arr);
    dfs(arr, 0);

    return res;
  }


  private static void dfs(int[] arr, int index) {
    // case last
    if (index == arr.length) {
      res.add(new ArrayList<>(path));
      return;
    }

    // enumerate nums
    for (int i = 0; i < arr.length; i++) {
      if (visited[i]) continue;
      if (i > 0 && arr[i - 1] == arr[i] && !visited[i - 1]) continue;

      // store scene
      visited[i] = true;
      path.add(arr[i]);
      dfs(arr, index + 1);
      // restore scene
      path.removeLast();
      visited[i] = false;
    }
  }
}
