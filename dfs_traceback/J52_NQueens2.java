public class J52_NQueens2 {

  private static int res = 0;
  private static boolean[] col, d, nd;


  public static void main(String[] args) {
    System.out.println(totalNQueens(Integer.parseInt(args[0])));
  }

  public static int totalNQueens(int n) {
    col = new boolean[n];
    d = new boolean[2 * n];
    nd = new boolean[2 * n];
    dfs(0, n);

    return res;
  }

  private static void dfs(final int queens, final int n) {
    // case: add a resolution
    if (queens == n) {
      res++;
      return;
    }

    // case: enumerate cols
    for (int i = 0; i < n; i++) {
      if (!col[i] && !d[queens + i] && !nd[queens - i + n]) {
        // case try add and cancel
        col[i] = d[queens + i] = nd[queens - i + n] = true;
        dfs(queens + 1, n);
        col[i] = d[queens + i] = nd[queens - i + n] = false;
      }
    }
  }
}
