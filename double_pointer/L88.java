class Solution {
    public void merge(int[] arr1, int m, int[] arr2, int n) {
        int index = arr1.length - 1;
        m--; n--;
        while (m >= 0 && n >= 0) {
            arr1[index--] = arr1[m] >= arr2[n] ? arr1[m--] : arr2[n--];
        }

        while (n >= 0) {
            arr1[index--] = arr2[n--];
        }
    }
}
