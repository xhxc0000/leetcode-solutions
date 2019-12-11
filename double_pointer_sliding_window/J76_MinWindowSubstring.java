public class J76_MinWindowSubstring {
  public static void main(String[] args) {
    String s = "ADOBECODEBANC", t = "ABC";
    System.out.println(minWindow(s, t));
  }

  public static String minWindow(String s, String t) {
    String res = "";
    // init map
    int[] map = new int[256];
    for (int i = 0; i < t.length(); i++) {
      map[t.charAt(i)]++;
    }
    int size = 0, count = 0;
    for (int i = 0; i < 256; i++) {
      size += map[i] > 0 ? 1 : 0;
    }

    // slide
    for (int i = 0, j = 0; i < s.length(); i++) {
      int c = s.charAt(i);
      map[c]--;
      if (map[c] == 0) count++;
      while (count == size && map[s.charAt(j)] < 0) map[s.charAt(j++)]++;
      if (count == size) {
        // update res
        if (res.equals("") || res.length() > i - j + 1) res = s.substring(j, i + 1);
      }
    }

    return res;
  }
}
