class Solution {
    // 1, 1, 2, 3, 5
    public int Fibonacci(int n) {
        //  if (n < 2) return n;
        //  return Fibonacci(n - 1) + Fibonacci(n - 2);
        return dfs(n);
    }
    
    public int dfs(int n) {
        if (n == 0) return 0;
        int[] f = new int[n + 1];
        f[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        
        return f[n];
    }
}
