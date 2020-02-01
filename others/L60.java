class Solution {
    public String getPermutation(int n, int k) {
        String res = "";
        StringBuilder nums = new StringBuilder();

        // init
        // 前缀积数组
        int[] factor = new int[n + 1];
        factor[0] = 1;
        for (int i = 1; i <= n; i++) {
            factor[i] = factor[i - 1] * i;
            nums.append(i);
        }
        
        final int loops = n;
        for (int i = 0; i < loops; i++) {
            n--;
            int index = (k - 1) / factor[n];
            res += nums.charAt(index);
            nums.deleteCharAt(index);
            k -= index * factor[n];
        }

        return res; 
    }
}
