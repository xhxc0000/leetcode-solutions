public class J50_Pow {
  public static void main(String[] args) {
    System.out.println(pow(3.1, 10));
  }


  public static double pow(double x, int n) {
    return n >= 0 ? fastPow(x, n) : fastPow(1 / x, (long)n * -1);
  }

  private static double fastPow(double x, long n) {
    if (n == 0) return 1.0;

    double half = fastPow(x, n / 2);
    if ((n & 1) == 1) return half * half * x;
    else return half * half;
  }
}
