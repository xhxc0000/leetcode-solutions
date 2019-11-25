public class FirstBadVersion {
  public static void main(String[] args) {

  }

  private static int firstBadVersion(int n) {
    int L = 1, R = n;
    while (L < R) {
      int mid = (L + R) >>> 1;
      if (isBadVersion(mid)) R = mid;
      else L = mid + 1;
    }

    return L;
  }
}
