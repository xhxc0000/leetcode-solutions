public class J684_RedundantConnection {
  public static void main(String[] args) {
    int[][] edge = {{1, 2}, {1, 3}, {2, 3}};
    int[] res = findRedundantConnection(edge);
    System.out.println(res[0] + " " + res[1]);
  }

  private static int[] prev;

  private static int find(int x) {
    if (prev[x] != x) prev[x] = find(prev[x]);

    return prev[x];
  }

  // 树中会有一条多余的边，找出多余的边
  // 多余的边会形成一条环，找出环中的最后一条边
  // 遍历每条边 节点 a, b
  // 判断 a, b是否已经在一个集合中，如果不在，union; 如果已经在一个集合中， 则ab边就是多余的
  public static int[] findRedundantConnection(int[][] edge) {
    int len = edge.length;
    prev = new int[len * 2];
    for (int i = 0; i < len * 2; i++) prev[i] = i;

    for (int i = 0; i < len; i++) {
      if (find(edge[i][0]) != find(edge[i][1])) {
        // union
        prev[find(edge[i][0])] = find(edge[i][1]);
      } else {
        return edge[i];
      }
    }

    return new int[] {-1, -1};
  }
}
