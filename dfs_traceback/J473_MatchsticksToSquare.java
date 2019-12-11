public class J473_MatchsticksToSquare {
  public static void main(String[] args) {
    System.out.println(makequeare(new int[] {1, 1, 2, 2, 2}));
  }

  private static boolean[] st;

  private static boolean makequeare(int[] arr) {
    int sum = 0;
    for (int i : arr) sum += i;
    if (sum % 4 != 0) return false;

    st = new boolean[arr.length];
    return dfs(arr, 0, 0, sum / 4);
  }

  private static boolean dfs(int[] arr, final int edge, final int cur, final int target) {
    if (edge == 4) return true;
    if (cur == target) return dfs(arr, edge + 1, 0, target);

    //
    for (int i = 0; i < arr.length; i++) {
      if (!st[i] && cur + arr[i] <= target) {
        // try add and cancel
        st[i] = true;
        if (dfs(arr, edge, cur + arr[i], target)) return true;
        st[i] = false;
      }
    }

    return false;
  }
}
