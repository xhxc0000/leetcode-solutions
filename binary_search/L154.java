class Solution {
    public int findMin(int[] arr) {
        if (arr.length < 1) return -1;
        int L = 0, R = arr.length - 1;
        while (R >= 0 && arr[R] == arr[0]) R--;
        if (R < 0) return arr[0];
        int val = arr[R];
        while (L < R) {
            int mid = L + R >>> 1;
            if (arr[mid] <= val) R = mid;
            else L = mid + 1;
        }

        return arr[L];
    }
}
