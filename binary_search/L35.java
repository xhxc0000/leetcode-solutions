class Solution {
    public int searchInsert(int[] arr, int target) {
        if (arr.length < 1) return 0;
        int L = 0, R = arr.length - 1;
        if (arr[R] < target) return arr.length;


        while (L < R) {
            int mid = L + R >>> 1;
            if (arr[mid] >= target) R = mid;
            else L = mid + 1;
        }

        return L;
    }
}
