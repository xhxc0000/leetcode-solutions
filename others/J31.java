public void nextPermutation(int[] arr) {
        int i = arr.length - 1;

        while (i > 0 && arr[i - 1] >= arr[i]) i--;
        if (i > 0) {
            int j = arr.length - 1;
            while (j >= 0 && arr[j] <= arr[i - 1]) j--;
            swap(arr, i - 1, j);
        }

        reverse(arr, i, arr.length - 1);
    }

