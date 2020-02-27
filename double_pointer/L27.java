class Solution {
    public int removeElement(int[] arr, int val) {
        int L = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) continue;

            arr[++L] = arr[i];
        }

        return L + 1;
    }
}
