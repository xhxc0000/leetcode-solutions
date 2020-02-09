class Solution {
    // 思路1(双指针)
    public void moveZeroes(int[] arr) {
        int n = arr.length, i = 0, j = 0;
        while (i < n) {
            while (i < n && arr[i] != 0) i++;
            j = i;
            while (j < n && arr[j] == 0) j++;
            if (j < n) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            i++;
        }
    }

    // 思路2
    public void moveZeroes(int[] arr) {
        int index = 0;
        for (int val : arr) {
            if (val != 0) arr[index++] = val;
        }
        for (int i = index; i < arr.length; i++) {
            arr[index++] = 0;
        }
    }
}
