public class J37_SudokuSolver {
  public static void main(String[] args) {

  }


   private boolean[][] row = new boolean[9][9];
   private boolean[][] col = new boolean[9][9];
   private boolean[][][] unit = new boolean[3][3][9];

   public void solveSudoku(char[][] board) {
       // init status
       for (int i = 0; i < 9; i++) {
           for (int j = 0; j < 9; j++) {
               if (board[i][j] != '.') {
                   // not empty, update status
                   int v = board[i][j] - '1';
                   row[i][v] = col[j][v] = unit[i / 3][j / 3][v] = true;
               }
           }
       }
       dfs(board, 0, 0);
   }

   private boolean dfs(char[][] board, final int x, final int y) {
       if (y == 9) return dfs(board, x + 1, 0);
       if (x == 9) return true;
       if (board[x][y] != '.') return dfs(board, x, y + 1);

       // enumerate cols
       for (int i = 0; i < 9; i++) {
           if (!row[x][i] && !col[y][i] && !unit[x / 3][y / 3][i]) {
                // not conflict
               board[x][y] = (char)('1' + i);
               row[x][i] = col[y][i] = unit[x / 3][y / 3][i] = true;
               if (dfs(board, x, y + 1)) return true;
               row[x][i] = col[y][i] = unit[x / 3][y / 3][i] = false;
               board[x][y] = '.';
           }
       }

       return false;
   }
}
