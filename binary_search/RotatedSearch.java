public class RotatedSearch {
  public static void main(String[] args) {
      // int[] arr = {4, 5, 6, 7, 0, 1, 2};
      int[] arr = {0, 1, 2, 3};

      System.out.println(search(arr, 1));
  }

  private static int search(int[] nums, int target) {
    if (nums.length == 0) return -1;
    int L = 0, R = nums.length - 1;
    int back = nums[R];

    while (L < R) {
      int mid = (L + R) >>> 1;
      if (nums[mid] <= back) R = mid;
      else L = mid + 1;
    }

    System.out.println("最小值:" + nums[L]);
    if (target <= back) {
      // case 从右边找
      R = nums.length - 1;
    } else {
      // case 从左边找
      R = L - 1;
      L = 0;
    }

    while (L < R) {
      int mid = (L + R) >>> 1;
      if (nums[mid] >= target) R = mid;
      else L = mid + 1;
    }

    return nums[L] == target ? L : -1;
  }
}
