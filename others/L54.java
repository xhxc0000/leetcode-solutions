class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m < 1) return new ArrayList<>();
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>(m * n);
        int tL = 0, tR = 0, bL = m - 1, bR = n - 1;
        while (tL <= bL && tR <= bR) {
            for (int i = tR; i <= bR; i++) res.add(matrix[tL][i]);
            for (int i = tL + 1; i <= bL; i++) res.add(matrix[i][bR]);
            if (tL != bL) {
                for (int i = bR - 1; i >= tR; i--) res.add(matrix[bL][i]);
            }
            if (tR != bR) {
                for (int i = bL - 1; i > tL; i--) res.add(matrix[i][tR]);
            }
            tL++; tR++; bL--; bR--;
        }

        return res;
    }
}
