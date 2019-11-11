import java.util.*;



public class ThreeSum {
  public static void main(String[] args) {
    int[] arr = {-1, 0, 1, 2, -1, -4};
    print(threeSum(arr));
  }

  private static void print(List<List<Integer>> res) {
    for (List<Integer> list : res) {
      for (int i : list) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }


  private static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    if (nums == null || nums.length < 2) {
      return res;
    }
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      if (nums[i] > 0) break;
      if (i > 0 && nums[i - 1] == nums[i]) continue;
      int L = i + 1, R = len - 1;
      while (L < R) {
        int sum = nums[L] + nums[R] + nums[i]; // 这里不用判断L是否会越界,越界情况不会进入循环
        if (sum == 0) {
          res.add(Arrays.asList(nums[i], nums[L], nums[R]));
          while (L < R && nums[L] == nums[L + 1]) L++;
          while (L < R && nums[R] == nums[R - 1]) R--;
          L++;
          R--;
        } else if (sum < 0) {
          L++;
        } else if (sum > 0) {
          R--;
        }
      }
    }

    return res;
  }
}
