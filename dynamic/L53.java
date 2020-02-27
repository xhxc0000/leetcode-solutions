class Solution {
    public int maxSubArray(int[] arr) {
        if (arr.length < 1) return Integer.MIN_VALUE;
        int[] f = new int[arr.length];
        int max = arr[0];
        f[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            f[i] = f[i - 1] >= 0 ? f[i - 1] + arr[i] : arr[i];
            max = Math.max(max, f[i]);
        }

        return max;
    }
}
