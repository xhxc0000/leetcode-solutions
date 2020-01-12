class Solution {
    
    private boolean[][] visited;
    
    public int movingCount(int threshold, int rows, int cols) {
        visited = new boolean[rows][cols];
        
        return dfs(threshold, rows, cols, 0, 0);
    }
    
    private int dfs(int threshold, int rows, int cols, int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j]) return 0;
        int a = i / 10 + i % 10;
        int b = j / 10 + j % 10;
        if (a + b > threshold) {
            visited[i][j] = true;
            return 0;
        }
        
        // store
        visited[i][j] = true;
        return 1 + dfs(threshold, rows, cols, i + 1, j) + dfs(threshold, rows, cols, i - 1, j) + dfs(threshold, rows, cols, i, j - 1) + dfs(threshold, rows, cols, i, j + 1);
    }
    
    
}
