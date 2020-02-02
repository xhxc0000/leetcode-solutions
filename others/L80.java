class Solution {
    public int removeDuplicates(int[] arr) {
        int i = 0;
        for (int x : arr) {
            if (i < 2 || x > arr[i - 2]) {
                arr[i++] = x;
            }
        }

        return i;
    }
}
