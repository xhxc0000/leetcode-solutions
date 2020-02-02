class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRow = false, firstCol = false;
        // 标记第一行
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                firstRow = true;
                break;
            }
        }
        // 标记第一列
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstCol = true;
                break;
            }
        }

        // 标记
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }

        if (firstRow) {
            for (int i = 0; i < n; i++) matrix[0][i] = 0;
        }
        if (firstCol) {
            for (int j = 0; j < m; j++) matrix[j][0] = 0;
        }
    }
}
