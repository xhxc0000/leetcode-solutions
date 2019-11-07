public class StringToInteger {
    public static void main(String[] args) {
      System.out.println(myAtoi("-42"));
    }

    private static int myAtoi(String str) {
      int res = 0;
      int symble = 1;
      int i = 0;

      while (i < str.length() && str.charAt(i) == ' ') {
        i++;
      }
      if (i < str.length() && str.charAt(i) == '-') symble = -1;
      if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')) i++;
      while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
        int pop = str.charAt(i) - '0';
        if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && pop > 7)) return symble > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        res  = res * 10 + pop;
        i++;
      }

      return res * symble;
    }
}
