import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MatrixSum {

    private static int[][] b;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] param = reader.readLine().split(" ");
        int n = Integer.parseInt(param[0]);
        int m = Integer.parseInt(param[1]);
        int q = Integer.parseInt(param[2]);
        int[][] a = new int[n + 1][m + 1];
        b = new int[n + 2][m + 2];

        // init matrix
        for (int i = 1; i <= n; i++) {
            String[] num = reader.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                a[i][j] = Integer.parseInt(num[j - 1]);
            }
        }

        // init difference matrix: b
        for (int i = 1; i<= n; i++) {
            for (int j = 1; j <= m; j++) {
                insert(i, j, i, j, a[i][j]);
            }
        }

        // execute operations
        for (int i = 0; i < q; i++) {
            String[] oper = reader.readLine().split(" ");
            insert(Integer.parseInt(oper[0]),
            Integer.parseInt(oper[1]),
            Integer.parseInt(oper[2]),
            Integer.parseInt(oper[3]),
            Integer.parseInt(oper[4]));
        }

        // prefix sum
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                b[i][j] += b[i - 1][j] + b[i][j - 1] - b[i - 1][j - 1];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }


    private static void insert(int x1, int y1, int x2, int y2, int c) {
        b[x1][y1] += c;
        b[x2 + 1][y1] -= c;
        b[x1][y2 + 1] -= c;
        b[x2 + 1][y2 + 1] += c;
    }
}
