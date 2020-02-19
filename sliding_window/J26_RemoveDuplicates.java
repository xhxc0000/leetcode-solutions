public class J26_RemoveDuplicates {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3};
    int len = removeDuplicates(arr);
    for (int val : arr) {
      System.out.print(val + " ");
    }
    System.out.println("len = " + len);
  }

  public static int removeDuplicates(int[] arr) {
    if (arr.length < 1) return 0;
    int i = 0, j = 1;
    for (; j < arr.length; j++) {
      if (arr[j] != arr[i]) {
        arr[++i] = arr[j];
      }
    }

    return i + 1;
  }
}
