class Solution {
    public boolean verifySequenceOfBST(int [] sequence) {
        return dfs(sequence, 0, sequence.length - 1);
    }
    
    
    private boolean dfs(int[] arr, int i, int j) {
        if (i >= j) return true;
        // double pointer
        int L = i, R = 0, val = arr[j];
        while (arr[L] < val) L++;
        
        R = L;
        while (R < j) {
            if (arr[R] < val) return false;
            R++;
        }
        
        return dfs(arr, i, L - 1) && dfs(arr, L, j - 1);
    }
}
