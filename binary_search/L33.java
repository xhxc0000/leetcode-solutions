class Solution {
    public int search(int[] arr, int target) {
        if (arr.length < 1) return -1;

        
        int L = 0, R = arr.length - 1;
        int val = arr[R];
        while (L < R) {
            int mid = L + R >>> 1;
            if (arr[mid] <= val) R = mid;
            else L = mid + 1;
        }
        if (target <= val) {
            R = arr.length - 1;
        } else {
            R = L - 1;
            L = 0;
        }

        while (L < R) {
            int mid = L + R >>> 1;
            if (arr[mid] >= target) R = mid;
            else L = mid + 1;
        }

        return arr[L] == target ? L : -1;
    }
}
