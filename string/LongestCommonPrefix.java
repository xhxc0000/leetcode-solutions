public class LongestCommonPrefix {
  public static void main(String[] args) {
    String[] strs = {"flower", "flow", "flight"};
    System.out.println(longestCommonPrefix(strs));
  }


  private static String longestCommonPrefix(String[] strs) {
    if (strs.length < 1) return "";
    String res = strs[0];
    StringBuilder sb = null;
    for (int i = 1; i < strs.length; i++) {
      sb = new StringBuilder();
      for (int j = 0; j < res.length(); j++) {
        if (j < strs[i].length() && res.charAt(j) == strs[i].charAt(j)) {
          sb.append(res.charAt(j));
        } else {
          break;
        }
      }
      res = sb.toString();
      if (res.equals("")) return res;
    }

    return res;
  }
}
