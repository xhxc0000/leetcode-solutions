class Solution {
    public int singleNumber(int[] arr) {
        int res = 0;
        for (int val : arr) res ^= val;

        return res;
    }
}
