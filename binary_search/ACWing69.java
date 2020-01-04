class Solution {
    public int getNumberSameAsIndex(int[] arr) {
        // if (arr.length < 1) return -1;
        int L = 0, R = arr.length - 1;
        while (L < R) {
            int mid = L + R >>> 1;
            if (arr[mid] < mid) L = mid + 1;
            else R = mid;
        }
        
       return L >= 0 && arr[L] == L ? L : -1;
    }
}
