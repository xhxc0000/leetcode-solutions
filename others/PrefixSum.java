import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrefixSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] param = reader.readLine().split(" ");
        int n = Integer.parseInt(param[0]);
        int m = Integer.parseInt(param[1]);

        String[] num = reader.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(num[i]);

        //init s
        int[] s = new int[n + 1];
        for (int i = 1; i < n + 1; i++) s[i] = s[i - 1] + arr[i - 1];

        for (int i = 0; i < m; i++) {
            param = reader.readLine().split(" ");
            System.out.println(s[Integer.parseInt(param[1])] - s[Integer.parseInt(param[0]) - 1]);
        }

    }
}
