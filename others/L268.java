class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length, sum = n * (n + 1) / 2;
        for (int val : arr) {
            sum -= val;
        }
        return sum;
    }
}
