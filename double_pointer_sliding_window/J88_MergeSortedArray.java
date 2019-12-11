public class J88_MergeSortedArray {
  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int[] nums2 = {2, 5, 6};
    merge(nums1, 3, nums2, 3);
    for (int val : nums1) {
      System.out.println(val);
    }
  }


  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int p = m - 1, q = n - 1, r = nums1.length - 1;
    while (p >= 0 && q >= 0) {
      nums1[r--] = nums1[p] >= nums2[q] ? nums1[p--] : nums2[q--];
    }

    while (q >= 0) {
      nums1[r--] = nums2[q--];
    }
  }
}
