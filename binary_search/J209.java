class J209 {
    // 前缀和 + 二分查找
    public int minSubArrayLen(int target, int[] arr) {
        if (arr.length < 1 || target == 0) return 0;
        // init prefix
        int[] s = new int[arr.length + 1];
        for (int i = 1; i < s.length; i++) s[i] = s[i - 1] + arr[i - 1];

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < s.length; i++) {
            res = Math.min(res, i - binarySearch(s, i, target) + 1);
        }
        return res <= arr.length ? res : 0;
    }

    private int binarySearch(int[] s, final int end, final int val) {
        int L = 1, R = end;
        while (L < R) {
            int mid = L + R + 1 >>> 1;
            if (s[end] - s[mid - 1] >= val) L = mid;
            else R = mid - 1;
        }
        if (s[end] - s[L - 1] >= val) return L;
        else return -1 * s.length;
    }
}
