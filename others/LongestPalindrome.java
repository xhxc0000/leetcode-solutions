public class LongestPalindrome {
  public static void main(String[] args) {
    String s = "";
    System.out.println(longestPalindrome(s));
  }


  private static String longestPalindrome(String s) {
    if (s == null || s == "") {
      return "";
    }
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      int len1 = expandAroundCenter(s, i, i);
      int len2 = expandAroundCenter(s, i, i + 1);
      int length = len1 > len2 ? len1 : len2;
      if (length > end - start + 1) {
        start = i - (length - 1) / 2;
        end = i + length / 2;
      }
    }

    return s.substring(start, end + 1);
  }


  private static int expandAroundCenter(String s, int l, int r) {
    while (l > -1 && r < s.length() && s.charAt(l) == s.charAt(r)) {
      l--;
      r++;
    }
    return r - l - 1;
  }
}
