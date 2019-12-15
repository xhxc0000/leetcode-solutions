public class DoubleSqrt {
  public static void main(String[] args) {
    System.out.println(sqrt2(0.1));
  }

  public static double sqrt(double x) {
    double L = 0, R = x;
    while (R - L > 1e-8) {
      double mid = (L + R) / 2;
      if (mid * mid >= x) R = mid;
      else L = mid;
    }

    return L;
  }

  public static double sqrt2(double x) {
    double L = 0, R = x;
    for (int i = 0; i < 100; i++) {
      double mid = (L + R) / 2;
      if (mid * mid >= x) R = mid;
      else L = mid;
    }

    return L;
  }
}
