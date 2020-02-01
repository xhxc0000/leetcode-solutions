class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m < 1) return 0;
        int n = grid[0].length;

        // init
        int[][] f = new int[m][n];
        f[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) f[i][0] = f[i - 1][0] + grid[i][0];
        for (int i = 1; i < n; i++) f[0][i] = f[0][i - 1] + grid[0][i];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
            }
        }

        return f[m - 1][n - 1];
    }
    // 空间压缩
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m < 1) return 0;
        int n = grid[0].length;

        // init
        int[] f = new int[n];
        f[0] = grid[0][0];
        for (int i = 1; i < n; i++) f[i] = f[i - 1] + grid[0][i];

        for (int i = 1; i < m; i++) {
            f[0] = f[0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                f[j] = Math.min(f[j], f[j - 1]) + grid[i][j];
            }
        }

        return f[n - 1];
    }
}
