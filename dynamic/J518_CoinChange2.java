public class J518_CoinChange2 {
  public static void main(String[] args) {
    int[] coins = {1, 2, 5};
    System.out.println(change(5, coins));
  }

  public static int change(int amount, int[] coins) {
    int[] f = new int[amount + 1];
    f[0] = 1;

    for (int c : coins) {
      for (int i = c; i <= amount; i++) {
        f[i] += f[i - c];
      }
    }

    return f[amount];
  }
}
