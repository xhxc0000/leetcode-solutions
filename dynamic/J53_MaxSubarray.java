public class J53_MaxSubarray {
  public static void main(String[] args) {
    int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5 ,4};
    System.out.println(maxSubarray(arr));
  }


  public static int maxSubarray(int[] arr) {
    int len = arr.length;
    int[] dp = new int[len];
    int res = arr[0];
    dp[0] = arr[0];
    for (int i = 1; i < len; i++) {
      dp[i] = dp[i - 1] > 0 ? arr[i] + dp[i - 1] : arr[i];
      res = Math.max(res, dp[i]);
    }

    return res;
  }
}
