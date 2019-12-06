public class J273_NumberToWords {
  public static void main(String[] args) {
    System.out.println(numberToWords(Integer.parseInt(args[0])));

  }



  private static String[] small = {"Zero", "One", "Tow", "Three", "Four", "Five",
  "Six", "Seven", "Eight", "Nine", "Ten",
  "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
  "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

  private static String[] decade = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

  private static String[] big = {"Billion", "Million", "Thousand", ""};


  public static String numberToWords(int num) {
    if (num == 0) return small[0];
    StringBuilder res = new StringBuilder();
    // 最多循环4次
    for (int i = 1000*1000*1000, j = 0; i > 0; i /= 1000, j++) {
      if (num >= i) {
        res.append(getPart(num / i)).append(big[j]).append(' ');
        num %= i;
      }
    }

    return res.toString().trim();
  }


  private static String getPart(int n) {

    StringBuilder res = new StringBuilder();
    if (n >= 100) {
      res.append(small[n / 100]).append(' ').append("Hundred").append(' ');
      n %= 100;
    }
    if (n == 0) return res.toString();

    if (n >= 20) {
      res.append(decade[n / 10]).append(' ');
      n %= 10; // 取个位
    }
    if (n == 0) return res.toString();

    res.append(small[n]).append(' ');

    return res.toString();
  }
}
