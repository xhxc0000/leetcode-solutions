public class J300_LongestIncreasingSubsequence {
  public static void main(String[] args) {
    int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
    System.out.println(lenghtOfLIS(arr));
  }


  public static int lenghtOfLIS(int[] arr) {
    int len = arr.length;
    int[] f = new int[len];

    for (int i = 0; i < len; i++) {
      f[i] = 1;
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) f[i] = Math.max(f[i], f[j] + 1);
      }
    }

    int res = 0;
    for (int val : f) if (res < val) res = val;

    return res;
  }
}
