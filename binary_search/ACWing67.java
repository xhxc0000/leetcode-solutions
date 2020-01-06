class Solution {
    public int getNumberOfK(int[] arr, int k) {
        if (arr.length < 1) return 0;
        // binary search
        int L = 0, R = arr.length - 1;
        int a = -1;
        while (L < R) {
            int mid = (L + R) >>> 1;
            if (arr[mid] >= k) R = mid;
            else L = mid + 1;
        }
        
        if (arr[L] != k) return 0;
        a = L;
        L = 0; R = arr.length - 1;
        while (L < R) {
            int mid = (L + R + 1) >>> 1;
            if (arr[mid] <= k) L = mid;
            else R = mid - 1;
        }
        
        return L - a + 1;
    }
}
