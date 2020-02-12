class Solution {
    public void rotate(int[] arr, int k) {
        if (arr.length < 1) return;
        int n = arr.length;
        k %= n;

        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    private void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++; r--;
        }
    }
}
