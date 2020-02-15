class Solution {
    public int findPeakElement(int[] arr) {
        if (arr.length < 1) return -1;

        int L = 0, R = arr.length - 1;
        while (L < R) {
            int mid = L + R >>> 1;
            if (arr[mid] > arr[mid + 1]) R = mid;
            else L = mid + 1;
        }

        return L;
    }
}
