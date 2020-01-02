public class Solution {
    // 递归版本
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1) return -1;
        if (n == 1) return 0;
        return (LastRemaining_Solution(n - 1, m) + m)
    }

    // 迭代优化
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1) return -1;
        int[] f = new int[n + 1];
        f[1] = 0;
        for (int i = 2; i <= n; i++) {
            f[i] = (f[i - 1] + m) % i;
        }
        
        return f[n];
    }
}
