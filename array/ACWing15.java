class Solution {
    public boolean searchArray(int[][] arr, int target) {
        if (arr.length < 1) return false;
        int m = arr.length, n = arr[0].length;
        
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            
            if (arr[i][j] == target) return true;
            else if (arr[i][j] < target) i++;
            else j--;
        }
        
        return false;
    }
}
