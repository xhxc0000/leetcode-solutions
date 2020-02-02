class Solution {
    public boolean search(int[] arr, int target) {
        if (arr.length < 1) return false;
        int L = 0, R = arr.length - 1;
        while (L < R) {
            int mid = L + R >>> 1;
            if (arr[mid] > arr[L]) {
                if (target >= arr[L] && target <= arr[mid]) {
                    R = mid;
                } else {
                    L = mid + 1;
                }
            } else if (arr[mid] < arr[L]) {
                if (target > arr[mid] && target <= arr[R]) {
                    L = mid + 1;
                } else {
                    R = mid;
                }
            } else {
                // case arr[mid] == arr[L]
                if (arr[L] == target) return true;
                L++;
            }
        }

        return arr[L] == target;
    }
}
