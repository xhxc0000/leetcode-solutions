class Solution {
    int m;
    int n;
    char[][] board;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    public void solve(char[][] board) {
        m = board.length;
        if (m < 1) return;
        n = board[0].length;
        this.board = board;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = '*';
            }
        }

        for (int i = 0; i < n; i++) {
            if (board[0][i] == '*') bfs(0, i);
            if (board[m - 1][i] == '*') bfs(m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            if (board[i][n - 1] == '*') bfs(i, n - 1);
            if (board[i][0] == '*') bfs(i, 0);
        } 

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '*') board[i][j] = 'X';
            }
        }
    }

    private void bfs(int a, int b) {
        board[a][b] = 'O';
        for (int i = 0; i < 4; i++) {
            int x = a + dx[i], y = b + dy[i];
            if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != '*') continue;
            bfs(x, y);
        }
    }
}
