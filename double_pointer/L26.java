class Solution {
    public int removeDuplicates(int[] arr) {
        if (arr.length < 2) return arr.length;
        int p = 1, q = 1;

        while (q < arr.length) {
            while (q < arr.length && arr[q] == arr[q - 1]) q++;
            if (q < arr.length) arr[p++] = arr[q++];
        }
    
        return p;
    }
}
