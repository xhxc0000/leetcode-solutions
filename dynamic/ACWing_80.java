class Solution {
    public int[] numberOfDice(int n) {
        int[][] f = new int[n + 1][6 * n + 1];
        // init
        for (int j = 1; j <= 6; j++) {
            f[1][j] = 1;
        }
        
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int k = 1; k <= Math.min(6, j); k++) {
                    f[i][j] += f[i - 1][j - k];
                }
            }
        }
        
        int[] res = new int[6 * n - n + 1];
        
        for (int i = 0; i < 6 * n - n + 1; i++) {
            res[i] = f[n][n + i];
        }
        
        return res;
    }
    // 滚动数组优化
    public int[] numberOfDice(int n) {
        int[] f = new int[6 * n + 1];
        
        for (int j = 1; j <= 6; j++) f[j] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 6 * n; j >= 1; j--) {
                f[j] = 0;
                for (int k = 1; k <= Math.min(6, j); k++) {
                    f[j] +=f[j - k];
                }
            }
        }
        
        // System.out.print("f: ");
        // for (int val : f) System.out.print(val + " ");
        // System.out.println();
        
        int[] res = new int[6 * n - n + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = f[n + i];
        }
        
        
        return res;
    }
}
