public class IntToRoman {
  public static void main(String[] args) {
    System.out.println(intToRoman(1));
    System.out.println(intToRoman(0));
  }

  private static String intToRoman(int num) {
    String[] key = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    int[] value = {1000, 900, 500, 400, 100, 90, 50 ,40 ,10, 9, 5, 4, 1};
    StringBuilder res = new StringBuilder();
    int index = 0;
    while (index < 13) {
      while (num >= value[index]) {
        res.append(key[index]);
        num -= value[index];
      }
      index++;
    }

    return res.toString();
  }
}
