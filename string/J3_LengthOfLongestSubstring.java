public class J3_LengthOfLongestSubstring {
  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("tmmzuxt"));
  }

  private static int lengthOfLongestSubstring(String s) {
    char[] hash = new char[256];
    int res = 0;

    for (int i = 0, j = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (hash[c] < 1) {
        hash[c] = 1;
        res = Math.max(res, i - j + 1);
      } else {
        System.out.println("dup + " + c);
        // case duplicate
        while (s.charAt(j) != c) hash[s.charAt(j++)] = 0;
        j++;
      }
    }

    return res;
  }
}
