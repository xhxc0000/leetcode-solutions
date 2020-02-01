class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 1;
        int tL = 0, tR = 0, bL = n - 1, bR = n - 1;
        while (tL <= bL && tR <= bR) {
            for (int i = tR; i <= bR; i++) res[tL][i] = count++;
            for (int i = tL + 1; i <= bL; i++) res[i][bR] = count++;
            if (tL != bL) {
                for (int i = bR - 1; i >= tR; i--) res[bL][i] = count++;
            }
            if (tR != bR) {
                for (int i = bL - 1; i > tL; i--) res[i][tR] = count++;
            }
            tL++; tR++; bL--; bR--;
        }

        return res;
    }
}
