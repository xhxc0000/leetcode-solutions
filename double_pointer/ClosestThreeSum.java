import java.util.*;
public class ClosestThreeSum {
  public static void main(String[] args) {
    int[] arr = {0, 2, 1, -3};
    System.out.println(threeSumClosest(arr, 1));
  }

  private static int threeSumClosest(int[] nums, int target) {
    if (nums == null) return Integer.MAX_VALUE;
    Arrays.sort(nums);
    int len = nums.length;
    int res = nums[0] + nums[1] + nums[len - 1];

    for (int i = 0; i < len; i++) {
      int L = i + 1, R = len - 1;
      while (L < R) {
        int sum = nums[i] + nums[L] + nums[R];
        res = Math.abs(target - res) < Math.abs(target - sum) ? res : sum;
        if (sum < target) {
          L++;
        } else if (sum > target) {
          R--;
        } else {
          return sum;
        }
      }
    }

    return res;
  }

}
