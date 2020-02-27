class Solution {
    public int[] twoSum(int[] arr, int target) {
        int L = 0, R = arr.length - 1;
        while (L < R) {
            int cur = arr[L] + arr[R];
            if (cur > target) R--;
            else if (cur < target) L++;
            else return new int[] {L + 1, R + 1};
        }

        return new int[] {-1, -1};
    }
}
