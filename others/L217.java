import java.util.*;
class Solution {
    public boolean containsDuplicate(int[] arr) {
        // Arrays.sort(arr);

        heapSort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) return true;
        }

        return false;
    }

    private void heapSort(int[] arr) {
        // init
        for (int i = arr.length / 2; i >= 0; i--) {
            down(arr, i, arr.length - 1);
        }
        int size = arr.length - 1;
        // sort
        for (int i = 0; i < arr.length; i++) {
            swap(arr, 0, size--);
            down(arr, 0, size);
        }
    }

    private void down(int[] arr, int index, int size) {
        int tmp = index;
        if (index * 2 + 1 <= size && arr[index] < arr[index * 2 + 1]) tmp = index * 2 + 1;
        if (index * 2 + 2 <= size && arr[tmp] < arr[index * 2 + 2]) tmp = index * 2 + 2;
        if (tmp != index) {
            swap(arr, index, tmp);
            down(arr, tmp, size);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
