public class SearchInsert {
  public static void main(String[] args) {
    int[] arr = {1, 3, 5, 6};
    System.out.println(searchInsert(arr, 7));
  }

  public static int searchInsert(int[] nums, int target) {
        int L = 0, R = nums.length;
        while (L < R) {
          int mid = (L + R) >>> 1;
          if (nums[mid] >= target) R = mid;
          else L = mid + 1;
        }

        return L;
  }
}
