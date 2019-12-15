public class J91_DecodeWays {
  public static void main(String[] args) {
    System.out.println(numDecodings("226"));
  }

  public static int numDecodings(String s) {
    int n = s.length();
    int[] f = new int[n + 1]; // 下标从１开始, f[i] 表示前i个数中有多少种解码方式
    f[0] = 1;
    for (int i = 1; i <= n; i++) {
      if (s.charAt(i - 1) != '0') f[i] += f[i - 1];
      if (i >= 2) {
        int de = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
        if (de >= 10 && de <= 26) f[i] += f[i - 2];
      }
    }

    return f[n];
  }
}
