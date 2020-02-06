class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 1) return 0;

        int s0 = 0, s1 = -prices[0], s2 = Integer.MIN_VALUE, s3 = Integer.MIN_VALUE, s4 = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {
            s1 = Math.max(s1, s0 -prices[i]);
            s2 = Math.max(s2, s1 + prices[i]);
            s3 = Math.max(s3, s2 - prices[i]);
            s4 = Math.max(s4, s3 + prices[i]);
        }

        return Math.max(0, s4);
    }
}
