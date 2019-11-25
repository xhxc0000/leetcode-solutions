public class Divide {
  public static void main(String[] args) {
    System.out.println(divide(7, -3));
  }


  private static int divide(int dividend, int divisor) {
    if (dividend >= 0 && divisor > 0) {
      return div(dividend, divisor);
    } else {
      return -1 * div(Math.abs(dividend), Math.abs(divisor));
    }
  }

  private static int div(int dividend, int divisor) {
    int res = 0;
    while (dividend >= divisor) {
      dividend -= divisor;
      res++;
    }

    return res;
  }
}
