import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Difference {

    private static int[] b;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] param = reader.readLine().split(" ");
        int n = Integer.parseInt(param[0]), q = Integer.parseInt(param[1]);

        int[] a = new int[n + 1];
        b = new int[n + 2];

        // read nums
        String[] num = reader.readLine().split(" ");
        for (int i = 1; i <= n; i++) a[i] = Integer.parseInt(num[i - 1]);

        // init b
        for (int i = 1; i <= n; i++) insert(i, i, a[i]);

        // read and execute operations
        for (int i = 0; i < q; i++) {
            String[] arg = reader.readLine().split(" ");
            insert(Integer.parseInt(arg[0]), Integer.parseInt(arg[1]), Integer.parseInt(arg[2]));
        }

        for (int i = 1; i <= n; i++) {
            b[i] += b[i - 1];
            System.out.print(b[i] + " ");
        }
    }


    private static void insert(int l, int r, int c) {
        b[l] += c;
        b[r + 1] -= c;
    }
}
