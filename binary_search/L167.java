class Solution {
    public int[] twoSum(int[] arr, int target) {
        if (arr.length < 1) return new int[] {-1, -1};

        for (int i = 0; i < arr.length; i++) {
            int sec = search(arr, target - arr[i]);
            if (sec != -1 && i != sec) return new int[] {Math.min(i, sec) + 1, Math.max(i, sec) + 1}; 
        }

        return new int[] {-1, -1};
    }

    private int search(int[] arr, int target) {
        int L = 0, R = arr.length - 1;
        while (L < R) {
            int mid = L + R >>> 1;
            if (arr[mid] >= target) R = mid;
            else L = mid + 1;
        }

        return arr[L] == target ? L : -1;
    }
}
