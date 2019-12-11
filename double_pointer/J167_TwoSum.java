public class J167_TwoSum {
  public static void main(String[] args) {
    int[] arr = {2, 7, 11, 15};
    arr = whileSolu(arr, 9);
    for (int val : arr) {
      System.out.print(val + " ");
    }
  }

  private static int[] twoSum(int[] arr, int target) {
    for (int i = 0, j = arr.length - 1; i < arr.length; i++) {
      // get min(num >= target)
      while (j > i && arr[i] + arr[j - 1] >= target) j--;
      if (arr[i] + arr[j] == target) return new int[] {i + 1, j + 1};
    }
    return new int[] {-1, -1};
  }

  private static int[] whileSolu(int[] arr, int target) {
    int L = 0, R = arr.length - 1;
    while (L < R) {
      if (arr[L] + arr[R] > target) R--;
      else if (arr[L] + arr[R] < target) L++;
      else return new int[] {L + 1, R + 1};
    }

    return new int[] {-1, -1};
  }
}
