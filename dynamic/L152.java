class Solution {
    public int maxProduct(int[] arr) {
        if (arr.length < 1) return 0;
        int maxPrefix = arr[0], minPrefix = arr[0];
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int a = maxPrefix * arr[i], b = minPrefix * arr[i];
            maxPrefix = Math.max(Math.max(a, b), arr[i]);
            minPrefix = Math.min(Math.min(a, b), arr[i]);
            res = Math.max(res, maxPrefix);
        }
        return res;
    }
}
