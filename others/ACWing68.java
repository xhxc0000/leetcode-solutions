class Solution {
    public int getMissingNumber(int[] arr) {
        int n = arr.length + 1;
        int sum = (n - 1) * n / 2;
        for (int val : arr) sum -= val;
        
        return sum;
    }
}
