import java.util.*;

public class J120_Triangle {
  public static void main(String[] args) {
    List<List<Integer>> tri = new
  }

  // dp也是枚举所有路径，从上到下枚举
  public static int minimumTotal(List<List<Integer>> triangle) {
     int n = triangle.size();
     long[][] f = new long[2][n];
     f[0][0] = triangle.get(0).get(0);
     for (int i = 1; i < n; i++)
     for (int j = 0; j <= i; j++) {
         if (j == 0) f[i][j] = f[i - 1 & 1][j] + triangle.get(i).get(j);  // case 只有右上
         else if (i == j) f[i][j] = f[i - 1 & 1][j - 1] + triangle.get(i).get(j); // case 只有左上
         else f[i][j] = Math.min(f[i - 1 & 1][j], f[i - 1 & 1][j - 1]) + triangle.get(i).get(j); // 左右都有
     }
     long res = Integer.MAX_VALUE;
     for (int i = 0; i < n; i++) {
         res = Math.min(res, f[n - 1 & 1][i]);
     }

     return (int)res;
  }

  // 因为计算f[i]只依赖f[i - 1], 故空间可以优化到O(n)
  public static int minimumTotal1(List<List<Integer>> triangle) {
    int n = triangle.size();
    long[][] f = new long[2][n];
    f[0][0] = triangle.get(0).get(0);
    for (int i = 1; i < n; i++)
    for (int j = 0; j <= i; j++) {
        if (j == 0) f[i & 1][j] = f[i - 1 & 1][j] + triangle.get(i).get(j);
        else if (i == j) f[i & 1][j] = f[i - 1 & 1][j - 1] + triangle.get(i).get(j);
        else f[i & 1][j] = Math.min(f[i - 1 & 1][j], f[i - 1 & 1][j - 1]) + triangle.get(i).get(j);
    }
    long res = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
        res = Math.min(res, f[n - 1 & 1][i]);
    }

    return (int)res;
  }
}
