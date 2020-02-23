class Solution {
    public int uniquePathsWithObstacles(int[][] obs) {
        int m = obs.length, n = obs[0].length;
        // long[][] f = new long[m][n];

        for (int i = 0; i < m; i++)
        for (int j = 0; j < n; j++) {
            if (obs[i][j] == 1) continue;
            if (i == 0 && j == 0) obs[i][j] = 1;
            if (i - 1 >= 0) obs[i][j] += obs[i - 1][j];
            if (j - 1 >= 0) obs[i][j] += obs[i][j - 1];
        }

        return (int)obs[m - 1][n - 1];
    }

}
