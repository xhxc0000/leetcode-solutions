public class J63_UniquePaths2 {
  public static void main(String[] args) {
    int[][] obs = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    System.out.println(uniquePathsWithObstacles(obs));
  }

  public static int uniquePathsWithObstacles(int[][] obs) {
    int m = obs.length, n = obs[0].length;
    long[][] f = new long[m][n];

    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++) {
        if (obs[i][j] == 1) continue;
        if (i == 0 && j == 0) f[i][j] = 1;
        if (i - 1 >= 0) f[i][j] += f[i - 1][j];
        if (j - 1 >= 0) f[i][j] += f[i][j - 1];
      }

      return (int)f[m - 1][n - 1];
   }
}
