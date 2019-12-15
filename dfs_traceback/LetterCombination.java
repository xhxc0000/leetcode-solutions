import java.util.*;


public class LetterCombination {

  static Map<String, String> map = new HashMap<>();

  static {
    map.put("2", "abc");
    map.put("3", "def");
    map.put("4", "ghi");
    map.put("5", "jkl");
    map.put("6", "mno");
    map.put("7", "pqrs");
    map.put("8", "tuv");
    map.put("9", "wxyz");
  }


  private static List<String> res = new ArrayList<>();



  public static void main(String[] args) {
   // solution("23");
   // print();
   // System.out.println("abc".substring(1));
   // System.out.println("1".substring(2));
  }

  private static void print() {
    for (String s : res) {
      System.out.println(s);
    }
  }



  private static List<String> solution(String digits) {
    if (digits == null) return res;
    dfs("", digits);


    return res;
  }

  private static void dfs(String combination, String next) {
    if (next.length() == 0) {
      res.add(combination);
      return;
    }

    String letters = map.get(next.substring(0, 1));
    for (int i = 0; i < letters.length(); i++) {
      String letter = letters.substring(i, i + 1);
      dfs(combination + letter, next.substring(1));
    }
  }
}
