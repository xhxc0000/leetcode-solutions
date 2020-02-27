class Solution {
    public int threeSumClosest(int[] arr, int target) {
        if (arr == null || arr.length < 2) return Integer.MAX_VALUE;

        Arrays.sort(arr);
        int min = arr[0] + arr[1] + arr[arr.length - 1];

        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            int L = i + 1, R = arr.length - 1;
            while (L < R) {
                int sum = arr[i] + arr[L] + arr[R];
                if (Math.abs(target - sum) < Math.abs(target - min)) min = sum;
                if (sum < target) {
                    L++;
                } else if (sum > target) {
                    R--;
                } else {
                    return sum;
                }
            }
        }

        return min;
    }
}
