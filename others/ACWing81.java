class Solution {
    public boolean isContinuous(int[] arr) {
        if (arr.length < 1) return false;
        
        Arrays.sort(arr);
        int idx = 0;
        while (arr[idx] == 0) idx++;
        
        for (int i = idx + 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) return false;
        }
        
        return arr[arr.length - 1] - arr[idx] <= 4;
    }
}
