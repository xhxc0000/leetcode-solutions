public class MatrixSearch {
  public static void main(String[] args) {
    int[][] arr = {{1,1}};
    System.out.println(searchMatrix(arr, 2));
  }

  private static boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0 || matrix[0].length == 0) return false;
    int m = matrix.length, n = matrix[0].length;

    int L = 0, R = m * n - 1;
    while (L < R) {
      int mid = (L + R) >>> 1;
      if (matrix[mid / n][mid % n] >= target) R = mid;
      else L = mid + 1;
    }

    return matrix[L / n][L % n] == target;
  }
}
