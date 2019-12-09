import java.util.*;
public class J216_CombinationSum3 {
  public static void main(String[] args) {
    ITUtils.iterate(combination(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
  }

  private static List<List<Integer>> res = new ArrayList<>();

  private static List<Integer> path = new ArrayList<>();

  // 找出所有相加之和为n的k个数的组合
  // 组合中只允许含有1-9的正整数
  // 每种组合中不存在重复的数字
  // 说明:所有数字都是正整数,解集不能包含重复的组合

  // 求组合数一般记起始下标,求排列数一般每次从头开始枚举
  private static List<List<Integer>> combination(int k, int n) {
    dfs(k, n, 1);

    return res;
  }

  private static void dfs(int remain_num, int remain_target, int start) {
    if (remain_num == 0) {
      if (remain_target == 0) res.add(new ArrayList<>(path));
      return;
    }

    // enumerate nums
    // ensure i are enough => 10 - i >= remain_num
    for (int i = start; i <= 10 - remain_num; i++) {
      if (remain_target >= i) {
        // try add and cancel
        path.add(i);
        dfs(remain_num - 1, remain_target - i, i + 1);
        path.remove(path.size() - 1);
      }
    }
  }
}
