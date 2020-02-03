class Solution {
    public int numTrees(int n) {
        if (n < 1) return 0;
        return dfs(1, n);
    }

    public int numTrees(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                f[i] += f[j - 1] * f[i - j];
            }
        }

        return f[n];
    }


    // 递归版本简单，但超时了
    private int dfs(int start, int end) {
        if (start > end) return 1;
        int res = 0;
        for (int i = start; i <= end; i++) {
            int left = dfs(start, i - 1);
            int right = dfs(i + 1, end);
            res += left * right;
        }

        return res;
    }
}
