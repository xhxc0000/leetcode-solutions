import java.util.*;
public class GenerateParenthesis {

  private static List<String> res = new ArrayList<>();

  public static void main(String[] args) {
    generateParenthesis(6);
    print(res);
  }

  private static List<String> generateParenthesis(int n) {
    if (n <= 0) return res;
    dfs("", n, n);
    return res;
  }

  private static void dfs(String combination, int remainLeft, int remainRight) {
    if (remainRight == 0) {
      res.add(combination);
      return;
    }

    if (remainRight > remainLeft) {
      dfs(combination + ")", remainLeft, remainRight - 1);
    }
    if (remainLeft > 0) {
      dfs(combination + "(", remainLeft - 1, remainRight);
    }
  }

  private static void print(List<String> list) {
    for (String s : list) {
      System.out.println(s);
    }
  }
}
