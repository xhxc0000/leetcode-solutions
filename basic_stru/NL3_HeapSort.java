public class NL3 {
      private static int[] arr;
      public static void heapSort(int[] array) {
          arr = array;
          if (arr == null || arr.length < 2) return;
          int size = arr.length;


          for (int i = size / 2; i >= 0; i--) {
              down(i, size);
          }

          while (size > 0) {
              swap(arr, 0, --size);
              down(0, size);
          }
      }

      private static void down(int i, final int size) {

          int tmp = i;
          if (i * 2 + 1 < size && arr[i] < arr[i * 2 + 1]) tmp = i * 2 + 1;
          if (i * 2 + 2 < size && arr[tmp] < arr[i * 2 + 2]) tmp = i * 2 + 2;

          if (tmp != i) {
              swap(arr, i, tmp);
              down(tmp, size);
          }
      }
}
