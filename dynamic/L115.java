class Solution {
    public int numDistinct(String s, String t) {
        int m = t.length(), n = s.length();
        int[][] f = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    f[0][0] = 1;
                } else if (i == 0) {
                    f[0][j] = 1;
                } else if (j == 0) {
                    // f[i][0] = 0;
                } else {
                    if (t.charAt(i - 1) == s.charAt(j - 1)) f[i][j] = f[i - 1][j - 1] + f[i][j - 1];
                    else f[i][j] = f[i][j - 1];
                }
            }
        }

        return f[m][n];
    }
}
