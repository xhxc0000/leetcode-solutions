import java.util.*;
public class J90_Subsets2 {
  public static void main(String[] args) {
    int[] arr = {1,1,2};
    List<List<Integer>> res = subsets(arr);
    for (List<Integer> list : res) {
      for (int i : list) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }

  private static List<List<Integer>> res = new ArrayList<>();
  private static List<Integer> path = new ArrayList<>();

  public static List<List<Integer>> subsets(int[] arr) {
    Arrays.sort(arr);
    dfs(arr, 0);

    return res;
  }

  private static void dfs(int[] arr, int index) {
    if (index == arr.length) {
      res.add(new ArrayList<>(path));
      return;
    }

    // 计算当前数字的个数
    int k = index;
    while (k < arr.length && arr[k] == arr[index]) k++;

    k = k - index;
    // eg. 1, 1  枚举
    for (int i = 0; i <= k; i++) {
      dfs(arr, index + k);
      path.add(arr[index]);
    }

    //restore scene
    for (int i = 0; i <= k; i++) path.remove(path.size() - 1);
  }
}
