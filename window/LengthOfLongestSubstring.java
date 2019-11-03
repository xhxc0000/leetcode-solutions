public class LengthOfLongestSubstring {
  public static void main(String[] args) {
    String s = "dvdf";
    System.out.println(lengthOfLongestSubstring(s));

  }

  public static int lengthOfLongestSubstring(String s) {
    char[] map = new char[256];
    int left = 0, right = 0;
    int res = 0, length = 0;

    while (right < s.length()) {
      if (map[s.charAt(right)] > 0) {
        map[s.charAt(left)] = 0;
        length = right - left++;
        res = res > length ? res : length;
      } else {
        map[s.charAt(right)]++;
        right++;
      }
    }
    length = s.length() - left;
    return res > length ? res : length;
  }
}
