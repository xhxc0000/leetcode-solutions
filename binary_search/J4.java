class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int n = arr1.length + arr2.length;
        if ((n & 1) == 1) {
            // case 奇数
            return findKth(arr1, arr2, n / 2 + 1);
        } else {
            // case 偶数
            return (findKth(arr1, arr2, (n >> 1)) + findKth(arr1, arr2, (n >> 1) + 1)) / 2.0;
        }
    }

    private int findKth(int[] arr1, int[] arr2, int k) {
        int n1 = arr1.length, n2 = arr2.length;
        int L = Math.max(0, k - n2), R = Math.min(k, n1);

        while (L < R) {
            int mid = L + R >>> 1;
            if (arr1[mid] >= arr2[k - mid - 1]) R = mid;
            else L = mid + 1;
        }
        // i - 1, j - 1可能越界
        int arr1Max = L - 1 < 0 ? Integer.MIN_VALUE : arr1[L - 1];
        int arr2Max = k - L - 1 < 0 ? Integer.MIN_VALUE : arr2[k - L - 1];

        return Math.max(arr1Max, arr2Max);
    } 
}
