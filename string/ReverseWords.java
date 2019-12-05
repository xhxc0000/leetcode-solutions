public class ReverseWords {
  public static void main(String[] args) {
    String s = "  hello     world!  ";
    System.out.println(reverseWords(s));
  }

  private static String reverseWords(String s) {
    StringBuilder res = new StringBuilder();
    s = s.trim();
    int i = s.length() - 1, j = s.length() - 1;
    while (i > 0) {
      if (s.charAt(i) == ' ') {
        res.append(s.substring(i + 1, j + 1));
        res.append(' ');
        // find tail of a world
        while (s.charAt(i) == ' ') i--;
        j = i;
      }
      i--;
    }

    return res.append(s.substring(i, j + 1)).toString();
  }
}
