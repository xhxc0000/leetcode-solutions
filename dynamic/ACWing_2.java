import java.io.*;

public class Main {

    private static int N;
    private static int V;

    private static int[] v;
    private static int[] w;
    private static int[][] f;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] param = reader.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        V = Integer.parseInt(param[1]);
        v = new int[N + 1];
        w = new int[N + 1];
        f = new int[N + 1][V + 1];

        for (int i = 1; i <= N; i++) {
            String[] num = reader.readLine().split(" ");
            v[i] = Integer.parseInt(num[0]);
            w[i] = Integer.parseInt(num[1]);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= v[i]) f[i][j] = Math.max(f[i][j], f[i - 1][j - v[i]] + w[i]);
            }
        }

        System.out.println(f[N][V]);
    }

    private static void optimisted() {
      for (int i = 1; i <= N; i++) {
          for (int j = V; j >= v[i]; j--) {
              f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
          }
      }

      System.out.println(f[V]);
    }
}
