public class FindMin {
  public static void main(String[] args) {
    // int[] arr = {3, 4, 5 ,1 ,2};
    int[] arr = {1, 2, 3, 4, 5};
    System.out.println(findMin(arr));

  }

  private static int findMin(int[] nums) {
    int L = 0, R = nums.length - 1;
    int back = nums[R];

    while (L < R) {
      int mid = (L + R) >>> 1;
      if (nums[mid] <= back) R = mid;
      else L = mid + 1;
    }

    return nums[L];
  }
}
