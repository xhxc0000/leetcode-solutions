public class J198_HouseRobber {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 1};
    System.out.println(rob1(arr));
  }

  public static int rob(int[] arr) {
    int len = arr.length;
    int[] f = new int[len + 1]; // f[i] 表示前[i]个数, 以i结尾，并且不选arr[i]的选法最大值
    int[] g = new int[len + 1]; // 以i结尾，并且选arr[i]的选法最大值

    for (int i = 1; i <= len; i++) {
      f[i] = Math.max(f[i - 1], g[i - 1]);
      g[i] = f[i - 1] + arr[i - 1];
    }

    return Math.max(f[len], g[len]);
  }


  public static int rob1(int[] arr) {
    int len = arr.length;
    int[]f = new int[len + 1]; // 前i个数的最优选择方案
    f[1] = arr[0];
    for (int i = 2; i <= len; i++) {
      f[i] = Math.max(f[i - 2] + arr[i - 1], f[i - 1]);
    }

    return f[len];

  }

  // max(f[i - 2] + arr[i], f[i - 1])
  public static int rob2(int[] arr) {
    int a = 0; // 不选前一个
    int cur = 0; // 选前一个

    for (int val : arr) {
      int tmp = cur;
      cur = Math.max(a + val, cur);
      a = tmp;
    }

    return cur;
  }
}
