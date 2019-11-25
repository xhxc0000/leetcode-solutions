public class Sqrt {
  public static void main(String[] args) {
    // System.out.println(sqrt(0));
    // System.out.println(sqrt(3));
    // System.out.println(sqrt(9));
    // System.out.println(sqrt(100));
    // System.out.println(sqrt(1000));
    System.out.println(Integer.MAX_VALUE);
    System.out.println(sqrt(2147483647));
  }


  private static int sqrt(int x) {
    int L = 0, R = x;
    while (L < R) {
      int mid = (int)(L + R + 1 >> 1);
      if (mid <= x / mid) L = mid;
      else R = mid - 1;
    }

    return L;
  }
}
