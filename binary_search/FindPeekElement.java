public class FindPeekElement {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 1};
    System.out.println(findPeakElement(arr));
  }

  private static int findPeakElement(int[] nums) {
    int L = 0, R = nums.length - 1;
    while (L < R) {
      int mid = (L + R) >>> 1;
      if (nums[mid] < nums[mid + 1]) {
        // case 峰值在右边
        L = mid + 1;
      } else if (nums[mid] > nums[mid + 1]) {
        // case 峰值在左边
        R = mid;
      }
    }

    return L;
  }
}
