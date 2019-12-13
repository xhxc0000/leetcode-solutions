import java.util.*;
public class J1_TwoSum {
  public static void main(String[] args) {
    int[] arr = {2, 7, 11, 15};
    int[] res = twoSum(arr, 9);
    System.out.println(res[0] + ":" + res[1]);
  }

  // map: val -> index
  public static int[] twoSum(int[] arr, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(target - arr[i])) {
        return new int[] {i, map.get(target - arr[i])};
      } else {
        map.put(arr[i], i);
      }
    }

    return new int[] {-1, -1};
  }
}
