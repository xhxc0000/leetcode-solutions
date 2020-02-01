class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // reverse each row
        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int tmp = matrix[i][l];
                matrix[i][l++] = matrix[i][r];
                matrix[i][r--] = tmp;
            }
        }
    }
}
