import java.util.*;
public class J560_SubarraySumEqualsK {
  public static void main(String[] args) {
    int[] arr = {0};
    System.out.println(subarraySum(arr, 0));
  }


  public static int subarraySum(int[] arr, int k) {
    int res = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);  // 模拟S[-1] = 0 -> 因为S[L,R] = S[R] - S[L-1]  L = 0时， L-1非法
    // 故这里手动设置S[-1] = 0

    for (int i = 0, sum = 0; i < arr.length; i++) {
      sum += arr[i];
      res += map.getOrDefault(sum - k, 0); // k = S[R] - S[L-1] == S[L,R] ==> key = S[L - 1]
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }


    return res;
  }
}
