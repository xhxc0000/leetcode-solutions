class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int L = 1, R = x;
        while (L < R) {
            int mid = L + R + 1 >>> 1;
            if (mid <= x / mid) L = mid;
            else R = mid - 1;
        }

        return L;
    }
}
