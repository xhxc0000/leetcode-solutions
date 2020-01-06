class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int k = n / 4;
        int rate = (int)(n / 4.0 + 0.5);
        // System.out.println(rate);
        for (int i = 0; i < n; i += k) {
            int[] range = getNumberOfK(arr, arr[i]);
            if (range[1] - range[0] + 1 > rate) return arr[i];
        }

        return -1;
    }

    private int[] getNumberOfK(int[] arr, int k) {
        // binary search
        int L = 0, R = arr.length - 1;
        int a = -1;
        while (L < R) {
            int mid = (L + R) >>> 1;
            if (arr[mid] >= k) R = mid;
            else L = mid + 1;
        }

        if (arr[L] != k) return new int[] {-1, -1};
        a = L;
        L = 0; R = arr.length - 1;
        while (L < R) {
            int mid = (L + R + 1) >>> 1;
            if (arr[mid] <= k) L = mid;
            else R = mid - 1;
        }

        return new int[] {a, L};
    }
}
