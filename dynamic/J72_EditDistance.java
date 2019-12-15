public class J72_EditDistance {
  public static void main(String[] args) {
    System.out.println(minDistance("horse", "ros"));
  }

  public static int minDistance(String word1, String word2) {
    int m = word1.length(), n = word2.length();
    int[][] f = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++) f[i][0] = i; // i行0列，i个删除操作
    for (int i = 0; i <= n; i++) f[0][i] = i; // 0行i列，i个添加操作


    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        // f[i][j] = 四类操作的最小值
        f[i][j] = Math.min(f[i][j - 1], f[i - 1][j]) + 1; // 添加，删除
        f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1)); // 替换还是非替换
        System.out.print(f[i][j] + " ");
      }
      System.out.println();
    }



    return f[m][n];
  }


  public static int minDistance1(String word1, String word2) {
   int n = word1.length();
   int m = word2.length();

   // if one of the strings is empty
   if (n * m == 0)
     return n + m;

   // array to store the convertion history
   int [][] d = new int[n + 1][m + 1];

   // init boundaries
   for (int i = 0; i < n + 1; i++) {
     d[i][0] = i;
   }
   for (int j = 0; j < m + 1; j++) {
     d[0][j] = j;
   }

   // DP compute
   for (int i = 1; i < n + 1; i++) {
     for (int j = 1; j < m + 1; j++) {
       int left = d[i - 1][j] + 1;
       int down = d[i][j - 1] + 1;
       int left_down = d[i - 1][j - 1];
       if (word1.charAt(i - 1) != word2.charAt(j - 1))
         left_down += 1;
       d[i][j] = Math.min(left, Math.min(down, left_down));
       System.out.print(d[i][j] + " ");
     }
     System.out.println();
   }
   return d[n][m];
 }
}
