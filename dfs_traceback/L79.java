class Solution {
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1, 0, 0};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length < 1) return false;
        int m = board.length,n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, 0, i, j, word)) return true;
            } 
        }

        return false;
    }

    private boolean dfs(char[][] board, int index, int a, int b, String s) {
        if (board[a][b] != s.charAt(index)) return false;
        if (index == s.length() - 1) return true;

        char tmp = board[a][b];
        board[a][b] = '*';

        for (int k = 0; k < 4; k++) {
            int x = a + dx[k], y = b + dy[k];
            if (x >= 0 
            && x < board.length 
            && y >= 0 
            && y < board[0].length 
            && dfs(board, index + 1, x, y, s)) {
                return true;
            }
        }

        // restore
        board[a][b] = tmp;

        return false;
    }
}
