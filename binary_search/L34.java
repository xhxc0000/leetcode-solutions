class Solution {
    public int[] searchRange(int[] arr, int target) {
        if (arr.length < 1) return new int[] {-1, -1};

        
        int L = 0, R = arr.length - 1;
        int[] res = new int[] {-1, -1};

        // find first
        while (L < R) {
            int mid = L + R >>> 1;
            if (arr[mid] >= target) R = mid;
            else L = mid + 1;
        }
        if (arr[L] != target) return res;
        res[0] = L;

        // find second
        L = 0; R = arr.length - 1;
        while (L < R) {
            int mid = L + R + 1 >>> 1;
            if (arr[mid] <= target) L = mid;
            else R = mid - 1;
        }

        res[1] = L;

        return res;
    }
}
