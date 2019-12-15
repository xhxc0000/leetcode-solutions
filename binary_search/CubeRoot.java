public class CubeRoot {
  public static void main(String[] args) {
    double x = -43.42;
    double res = cubeRoot(x);
    DecimalFormat df = new DecimalFormat("0.000000");
    System.out.println(df.format(res));
  }

  public static double cubeRoot(double x) {
    double L = -1 * Math.abs(x), R = Math.abs(x);
    while (R - L > 1e-8) {
        double mid = (L + R) / 2;
        if (mid * mid * mid >= x) R = mid;
        else L = mid;
    }

    return L;
  }
}
