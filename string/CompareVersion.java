public class CompareVersion {
  public static void main(String[] args) {
    System.out.println(what("0.1", "1.1"));
  }

  private static int compareVersion(String s1, String s2) {
    int i = 0, j = 0;
    while (i < s1.length() || j < s2.length()) {
      int x = i, y = j;
      while (x < s1.length() && s1.charAt(x) != '.') x++;
      while (y < s2.length() && s2.charAt(y) != '.') y++;

      // case1 x in <len, .>
      // case2 x == i == len
      int a = x == i ? 0 : Integer.parseInt(s1.substring(i, x));
      int b = y == j ? 0 : Integer.parseInt(s2.substring(j, y));

      if (a != b) {
        return a > b ? 1 : -1;
      }
      i = x + 1; j = y + 1;
    }

    return 0;
  }
}
