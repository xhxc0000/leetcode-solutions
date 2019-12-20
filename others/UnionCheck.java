// 并查集
public class UnionCheck {
  public static void main(String[] args) {

  }

  private int[] pre = new pre[100010];

  // 路径压缩
  private int find(int x) {
    if (pre[x] != x) pre[x] = find(pre[x]);  // 太屌了
    return pre[x];
  }

  public void merge(int a, int b) {
    pre[find(a)] = find(b);
  }

  public boolean query(int a, int b) {
    return find(a) ==  find(b);
  }
}
