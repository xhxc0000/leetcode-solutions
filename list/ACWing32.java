class Solution {
    public void reOrderArray(int[] arr) {
        int L = 0, R = arr.length - 1;
        
        while (L < R) {
            while ((arr[L] & 1) == 1) L++;
            while ((arr[R] & 1) == 0) R--;
            if (L < R) {
                int tmp = arr[L];
                arr[L++] = arr[R];
                arr[R--] = tmp;
            }
        }
    }
}
