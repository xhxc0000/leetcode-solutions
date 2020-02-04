class Solution {
    // 空间压缩版
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) return false;
        boolean[] f = new boolean[n + 1];
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    f[j] = true;
                } else if (i == 0) {
                    f[j] = f[j - 1] && s3.charAt(j - 1) == s2.charAt(j - 1);
                } else if (j == 0) {
                    f[j] = f[j] && s3.charAt(i - 1) == s1.charAt(i - 1);
                } else {
                    f[j] = f[j] && s3.charAt(i + j - 1) == s1.charAt(i - 1) ||
                        f[j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1);
                }
            }
        }

        return f[n];
    }




    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) return false;
    
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 0 || j == 0) {
                    f[i][j] = true;
                } else if (i == 0) {
                    f[0][j] = f[0][j - 1] && s3.charAt(j - 1) == s2.charAt(j - 1);
                } else if (j == 0) {
                    f[i][0] = f[i - 1][0] && s3.charAt(i - 1) == s1.charAt(i - 1);
                } else {
                    f[i][j] = f[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1) ||
                        f[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1);
                }
            }
        }

        return f[m][n];
    }
}
