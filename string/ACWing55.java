class Solution {
    public int maxSubArray(int[] arr) {
        int res = arr[0];
        
        int[] f = new int[arr.length];
        f[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            f[i] = f[i - 1] > 0 ? f[i - 1] + arr[i] : arr[i];
            res = Math.max(res, f[i]);
        }
        
        return res;
    }
}
