public class IsPalindrom {
  public static void main(String[] args) {
    System.out.println(betterSolution(10));
  }

  private static boolean isPalindrom(int x) {
    String s = String.valueOf(x);
    StringBuilder sb = new StringBuilder(s);
    String rev = sb.reverse().toString();
    return rev.equals(s);
  }

  private static boolean betterSolution(int x) {
    if (x < 0 || x % 10 == 0) return false;
    int inc = 0;
    while (x > inc) {
      inc = inc * 10 + x % 10;
      x /= 10;
    }
    return (x == inc || x == inc / 10);
  }
}
