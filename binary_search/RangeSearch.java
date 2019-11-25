public class RangeSearch {
  public static void main(String[] args) {
    int[] arr = {5, 7, 7, 8, 8, 10};

    System.out.println(searchRange(arr, 5)[1]);
    System.out.println(searchRange(arr, 7)[1]);
    System.out.println(searchRange(arr, 8)[1]);
    System.out.println(searchRange(arr, 10)[1]);
    System.out.println(searchRange(arr, 11)[1]);

  }

  private static int[] searchRange(int[] nums, int target) {
    if (nums.length == 0) return new int[] {-1, -1};

    int L = 0, R = nums.length - 1;
    int resL = -1, resR = -1;
    while (L < R) {
      int mid = (L + R) >>> 1;
      if (nums[mid] >= target) R = mid;
      else L = mid + 1;
    }

    resL = L;
    if (nums[L] != target) return new int[] {-1, -1};

    L = 0; R = nums.length - 1;
    while (L < R) {
      int mid = (L + R + 1) >>> 1;
      if (nums[mid] <= target) L = mid;
      else R = mid - 1;
    }

    resR = L;
    return new int[] {resL, resR};
  }
}
