class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
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
