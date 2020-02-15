class Solution {
    public int[] twoSum(int[] arr, int target) {
        int L = 0, R = arr.length - 1;

        while (L < R) {
            int sum = arr[L] + arr[R];
            if (sum == target) {
                return new int[] {L + 1, R + 1};
            } else if (sum < target) {
                L++;
            } else {
                R--;
            }
        }

        return new int[] {-1, -1};
    }
}
