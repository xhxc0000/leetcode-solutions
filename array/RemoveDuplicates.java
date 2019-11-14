public class RemoveDuplicates {
  public static void main(String[] args) {

    int[] arr = {0, 0, 1, 1, 1, 2 ,2 ,3 ,3, 4};

    int res = removeDuplicates(arr);
    System.out.println("length:" + res);
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.println();

  }

  private static int removeDuplicates(int[] nums) {
    if (nums == null || nums.length < 1) return 0;
    int L = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) {
        continue;
      } else {
        nums[++L] = nums[i];
      }
    }

    return L + 1;
  }
}
