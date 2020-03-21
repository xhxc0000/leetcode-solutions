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

	// 浮点二分
	private static double sqrt2(int val) {
        double L = 0, R = val;
        final double ACC = 0.0001;
        double mid = 0;
        while ((R - L) > ACC) {
            mid = (L + R) / 2;
            if (mid * mid > val) {
                R = mid;
            } else {
                L = mid;
            }
        }

        return mid;
    }
}
