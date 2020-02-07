class Solution {
    public int minCut(String s) {
        if (s.length() < 1) return 0;
        int[] f = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (!isPalindrome(s, 0, i)) {
                f[i] = f[i - 1] + 1;
                for (int j = 1; j < i; j++) {
                    if (isPalindrome(s, j, i)) f[i] = Math.min(f[i], f[j - 1] + 1);
                }
            }
        }

        return f[s.length() - 1];
    }

    private boolean isPalindrome(String s, int L, int R) {
        while (L <= R) {
            if (s.charAt(L) == s.charAt(R)) {
                L++; R--;
            } else {
                return false;
            }
        }

        return true;
    }

    // dp优化
    public int minCut(String s) {
        int len = s.length();
        if (len < 1) return 0;
        int[] f = new int[len];
        boolean[][] dp = new boolean[len][len];
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) dp[i][j] = true;
            }
        }
        
        for (int i = 1; i < s.length(); i++) {
            if (!dp[0][i]) {
                f[i] = f[i - 1] + 1;
                for (int j = 1; j < i; j++) {
                    if (dp[j][i]) f[i] = Math.min(f[i], f[j - 1] + 1);
                }
            }
        }

        return f[s.length() - 1];
    }
}
