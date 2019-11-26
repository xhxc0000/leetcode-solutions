public class FindDuplicate {
  public static void main(String[] args) {
    int[] arr = {3,1,3,4,2};
    System.out.println(findDuplicate(arr));
  }

  private static int findDuplicate(int[] nums) {
    int n = nums.length - 1;
    int L = 1, R = n;
    while (L < R) {
      int mid = (L + R) >>> 1;
      int count = 0;
      // divide [L,R] to [L,mid], [mid + 1, R]
      for (int x : nums) {
        count += x <= mid ? 1 : 0;
      }
      if (count > mid) {
        // case to [L,mid]
        R = mid;
      } else {
        // case to [mid + 1, R]
        L = mid + 1;
      }
    }

    return L;
  }
}
