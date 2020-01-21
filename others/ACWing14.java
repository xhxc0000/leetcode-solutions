class Solution {
    public int duplicateInArray(int[] arr) {
        int L = 1, R = arr.length - 1;
        while (L < R) {
            int mid = L + R >> 1;
            int s = 0;
            for (int val : arr) s += val >= L && val <= mid ? 1 : 0;
            if (s > mid - L + 1) R = mid;
            else L = mid + 1;
        }
        return R;
    }
}
