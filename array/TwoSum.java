import java.util.*;

public class TwoSum {
  public static void main(String[] args) throws Exception {
    int[] arr = {1, 2, 6, 4, 5, 6};
    int[] res = twoSum(arr, 4);
    System.out.println(res[0]);
    System.out.println(res[1]);
  }


  private static int[] twoSum(int[] nums, int target) throws IllegalArgumentException {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        return new int[] {i, map.get(target-nums[i])};
      } else {
        map.put(nums[i], i);
      }
    }

    throw new IllegalArgumentException("no res");
  }
}
