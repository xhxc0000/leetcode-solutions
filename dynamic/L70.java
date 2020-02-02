class Solution {
    public int climbStairs(int n) {
        if (n == 0) return 1;
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }
    // 空间压缩
    public int climbStairs(int n) {
        int a = 1, b = 1; // a = f[i - 2], b = f[i - 1], 保证循环不变式
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        return b;
    }
}
