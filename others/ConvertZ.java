public class ConvertZ {
  public static void main(String[] args) {
    System.out.println(convertt("LEETCODEISHIRING", 3));
  }

  private static String convertt(String s, int numRows) {
    StringBuilder sb = new StringBuilder();
    int step = 2 * numRows - 2;
    int index = 0;
    int bin = 0;

    for (int i = 0; i < numRows; i++) {
      bin = 2 * i;
      index = i;
      while (index < s.length()) {
        sb.append(s.charAt(index));
        bin = step - bin;
        index += (i == 0 || i == numRows - 1) ? step : bin;
      }
    }

    return sb.toString();
  }





















}
