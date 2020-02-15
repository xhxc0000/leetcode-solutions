class Solution {
    public int search(int[] arr, int target) {
        if (arr.length < 1) return -1;
        int L = 0, R = arr.length - 1;

        while (L < R) {
            int mid = L + R >>> 1;
            if (arr[mid] >= target) R = mid;
            else L = mid + 1;
        }

        return arr[L] == target ? L : -1;
    }
}
