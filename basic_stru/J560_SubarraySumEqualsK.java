import java.util.*;
public class J560_SubarraySumEqualsK {
  public static void main(String[] args) {
    int[] arr = {0, 0};
    subarraySum(arr, 0);
    System.out.println(subarraySum(arr, 2));
  }


  public static int subarraySum(int[] arr, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int res = 0;

    for (int i = 0, sum = 0; i < arr.length; i++) {
      sum += arr[i];
      res += map.getOrDefault(sum - k, 0);
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }

    return res;
  }
}
