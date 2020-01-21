class Solution {


    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') continue;

                if (!set.add(num + "in row" + i) 
                || !set.add(num + "in col" + j) 
                || !set.add(num + "in block" + i/3 + "-" + j/3)) return false;
            }
        }

        return true;
    }



    public boolean isValidSudoku(char[][] board) {
        // row
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i)) return false;
        }

        // col
        for (int i = 0; i < 9; i++) {
            if (!isValidCol(board, i)) return false;
        }

        // 3*3
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValidArea(board, i, j)) return false;
            }
        }

        return true;
    }


    private boolean isValidRow(char[][] board, int row) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == '.') continue;
            if (set.contains(board[row][i])) return false;
            set.add(board[row][i]);
        }

        return true;
    }

    private boolean isValidCol(char[][] board, int col) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == '.') continue;
            if (set.contains(board[i][col])) return false;
            set.add(board[i][col]);
        }

        return true;
    }

    private boolean isValidArea(char[][] board, int row, int col) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[row + i][col + j] == '.') continue;
                if (set.contains(board[row + i][col + j])) return false;
                set.add(board[row + i][col + j]);
            }
        }

        return true;
    }
}
