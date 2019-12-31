class Solution {

    private List<List<String>> res = new ArrayList<>();
    private boolean[] col;
    private boolean[] diag;
    private boolean[] ndiag;
    private int[][] q;
    private int n;

    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        diag = new boolean[2 * n];
        ndiag = new boolean[2 * n];
        q = new int[n][n];
        this.n = n;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                q[i][j] = '.';
        }

        dfs(0);
        return res;
    }

    private void dfs(int row) {
        if (row == n) {
            addres();
        }

        // enumerate cols
        for (int i = 0; i < n; i++) {
            if (!col[i] && !diag[row - i + n] && !ndiag[row + i]) {
                // store
                col[i] = diag[row - i + n] = ndiag[row + i] = true;
                q[row][i] = 'Q';
                dfs(row + 1);
                // restore
                col[i] = diag[row - i + n] = ndiag[row + i] = false;
                q[row][i] = '.';
            }
        }
    }

    private void addres() {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append((char)q[i][j]);
            }
            path.add(sb.toString());
        }
        res.add(path);
    }
}
