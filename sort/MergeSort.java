public class MergeSort {
  public static void main(String[] args) {
    int len = 100;
    int[] arr = new int[len];
    for (int i = 0; i < len; i++) arr[i] = (int)(Math.random() * 100);

    mergeSort(arr);
    for (int val : arr) System.out.print(val + " ");
    System.out.println();
  }

  public static void mergeSort(int[] arr){
    mergeSort(arr, 0, arr.length - 1);
  }

  //[l,r]
  private static void mergeSort(int[] arr, int l, int r) {
    if (l == r) return;

    int mid = l + r >> 1;
    mergeSort(arr, l, mid);
    mergeSort(arr, mid + 1, r);
    merge(arr, l, mid, r);
  }

  private static void merge(int[] arr, int l, int m, int r) {
    int p = l, q = m + 1;
    int[] tmp = new int[r - l + 1];
    int i = 0;

    while (p <= m && q <= r) tmp[i++] = arr[p] < arr[q] ? arr[p++] : arr[q++];
    while (p <= m) tmp[i++] = arr[p++];
    while (q <= r) tmp[i++] = arr[q++];

    for (int val : tmp) arr[l++] = val;
  }
}
