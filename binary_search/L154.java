class Solution {
    public int findMin(int[] arr) {
        if (arr.length < 1) return -1;
        int L = 0, R = arr.length - 1;
        while (R > 0 && arr[R] == arr[0]) R--;
        int back = arr[R];

        while (L < R) {
            int mid = L + R >>> 1;
            if (arr[mid] <= back) R = mid;
            else L = mid + 1;
        }

        return arr[L];
    }
}
