class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length < 1) return false;
        int m = matrix.length, n = matrix[0].length;

        for (int i = 0, j = n - 1; i < m && j >= 0;) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) j--;
            else i++;
        }

        return false;
    }
}
