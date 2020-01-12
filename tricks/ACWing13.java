class Solution {
    public int duplicateInArray(int[] arr) {
        int len = arr.length;
        for (int val : arr) {
            if (val >= len) return -1;
        }
        
        for (int i = 0; i < arr.length; ) {
            if (i != arr[i]) {
                if (arr[arr[i]] == arr[i]) return arr[i];
                int t = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i] = t;
            } else {
                i++;
            }
        }
        
        return -1;
    }
}
