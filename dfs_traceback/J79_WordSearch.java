public class J79_WordSearch {
  public static void main(String[] args) {
    char[][] board = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
    System.out.println(exits(board, args[0]));
  }


  public static boolean exits(char[][] board, String word) {
    if (board.length < 1 || board[0].length < 1) return false;
    int m = board.length, n = board[0].length;
    //enumerate origin
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (dfs(board, word, 0, i, j)) {
          return true;
        }
      }
    }
    return false;
  }


  private static int[] dx = {1, -1, 0, 0};
  private static int[] dy = {0, 0, -1, 1};

  private static boolean dfs(char[][] board, String word, int index, int x, int y) {
    // case matching
    if (board[x][y] != word.charAt(index)) return false;
    // case last
    if (index == word.length() - 1) return true;
    // store scene
    char tmp = board[x][y];
    board[x][y] = '*';
    // enumerate direction
    for (int i = 0; i < 4; i++) {
      int a = x + dx[i], b = y + dy[i];
      if (a >= 0 && a < board.length && b >= 0 && b < board[0].length && dfs(board, word, index + 1, a, b)) {
        return true;
      }
    }
    // restore scene
    board[x][y] = tmp;
    return false;
  }
}
