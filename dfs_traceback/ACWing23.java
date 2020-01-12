class Solution {
    
    public boolean hasPath(char[][] matrix, String str) {
        if (matrix.length < 1) return false;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(matrix, str, 0, i, j)) return true;
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] matrix, String s, int index, int i, int j) {
        if (matrix[i][j] != s.charAt(index)) return false;
        if (index == s.length() - 1) return true;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        //store
        char tmp = matrix[i][j];
        matrix[i][j] = '*';
        
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && dfs(matrix, s, index + 1, x, y)) {
                return true;
            }
        }
        
        // restore
        matrix[i][j] = tmp;
        
        return false;
        
    }
}
