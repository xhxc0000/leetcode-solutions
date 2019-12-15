public class J547_FriendCircles {
  public static void main(String[] args) {
    int[][] matrix = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
    System.out.println(findCircleNum(matrix));
  }


  private static int[] pre;  // pre[i] is i's ancestor

  public static int findCircleNum(int[][] M) {
    int len = M.length;
    int res = len;
    pre = new int[len];
    for (int i = 0; i < len; i++) pre[i] = i;

    for (int i = 0; i < len; i++)
       for (int j = 0; j < i; j++) {
           if (M[i][j] == 0) continue;
           if (find(i) != find(j)) {
               // case join
               pre[find(i)] = find(j);
               res--;
           }
       }
     return res;
  }

  // 查找祖先节点
  private static int find(int x) {
    if (pre[x] != x) pre[x] = find(pre[x]);

    return pre[x];
  }
}
