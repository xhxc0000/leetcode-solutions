class Solution {

    public int maxProfit(int[] prices) {
        int[] f = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            f[i] = prices[i] - prices[i - 1];
        }
        
        int res = 0;
        for (int i = 1; i < f.length; i++) {
            f[i] = Math.max(f[i], f[i] + f[i - 1]);
            res = Math.max(res, f[i]);
        }

        return res;
    }

    // 空间压缩
    public int maxProfit(int[] prices) {
        int pre = 0, max = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            pre = Math.max(diff, diff + pre);
            max = Math.max(max, pre);
        }
        
        return max;
    }
}
