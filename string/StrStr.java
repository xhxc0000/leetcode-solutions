public class StrStr {
  public static void main(String[] args) {
    System.out.print(strStr("aaaaaa", "bba"));
  }

  private static int strStr(String hayStack, String needle) {
    if (needle == null || needle.equals("")) {
      return 0;
    }

    for (int i = 0; i < hayStack.length(); i++) {
      int index = i;
      for (int j = 0; j < needle.length(); j++) {
        if (index < hayStack.length() && hayStack.charAt(index) == needle.charAt(j)) {
          if (j == needle.length() - 1) {
            return index - j;
          } else {
            index++;
          }
        } else {
          break;
        }
      }
    }

    return -1;
  }
}
