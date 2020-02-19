class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        if (arr.length < 1) return 0;

        int min = Integer.MAX_VALUE, sum = 0;
        int left = 0, right = 0;
        while (right < arr.length) {
            sum += arr[right++];
            while (sum >= target) {
                min = Math.min(min, right - left);
                sum -= arr[left];
                left++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    
    }
}
