class Solution {
    // 旋转数组的最小数字（版本二：数组可能包含重复项，则移动R，去掉末尾重复项）
    public int findMin(int[] arr) {
        if (arr.length < 1) return -1;
        int L = 0, R = arr.length - 1;
        while(R > 0 && arr[R - 1] == arr[R]) R--;
        R--;
        int val = arr[R];
        while (L < R) {
            int mid = L + R >>> 1;
            if (arr[mid] <= val) R = mid;
            else L = mid + 1;
        }
        
        return arr[L];
    }
}
