class Solution {

    private int n;
    private boolean[] cols;
    private boolean[] diag;
    private boolean[] ndiag;
    private int res = 0;

    public int totalNQueens(int n) {
        this.n = n;
        cols = new boolean[n];
        diag = new boolean[n * 2];
        ndiag = new boolean[n * 2];

        dfs(0);

        return res;
    }

    private void dfs(final int queens) {
        if (queens == n) {
            res++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!cols[i] && !diag[queens - i + n] && !ndiag[queens + i]) {
                // try and cancel
                cols[i] = diag[queens - i + n] = ndiag[queens + i] = true;
                dfs(queens + 1);
                cols[i] = diag[queens - i + n] = ndiag[queens + i] = false;
            }
        }
    }
}
