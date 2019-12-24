class Solution {
    public int[] plusOne(int[] arr) {
        int add = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] += add;
            if (arr[i] < 10) return arr;
            arr[i] %= 10;
        }

        int[] res = new int[arr.length + 1];
        res[0] = 1;
        return res;
    }
}
