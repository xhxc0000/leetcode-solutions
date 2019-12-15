public class QuickSort {
  public static void main(String[] args) {
    int len = 100;
    int[] arr = new int[len];
    for (int i = 0; i < len; i++) arr[i] = (int)(Math.random() * 100);

    quickSort(arr);
    for (int val : arr) System.out.print(val + " ");
    System.out.println();
  }

  public static void quickSort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
  }

  private static void quickSort(int[] arr, int l, int r) {
    if (l >= r) return;

    // partition
    int pivot = arr[l], i = l - 1, j = r + 1;
    while (i < j) {
      while (arr[++i] < pivot);
      while (arr[--j] > pivot);
      if (i < j) swap(arr, i, j);
    }

    quickSort(arr, l, j);
    quickSort(arr, j + 1, r);
  }


  private static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
