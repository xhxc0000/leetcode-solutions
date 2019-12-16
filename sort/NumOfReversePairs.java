import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumOfReversePairs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[] arr = new int[n];
        String[] num = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(num[i]);

        System.out.println(mergeSort(arr, 0, n - 1));
    }


    private static long mergeSort(int[] arr, int l, int r) {
        if (l == r) return 0;

        int mid = l + r >>> 1;

        long res = mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r);
        res += merge(arr, l, mid, r);

        return res;
    }

    private static long merge(int[] arr, int l, int m, int r) {
        long res = 0;
        int p = l, q = m + 1;
        int[] tmp = new int[r - l + 1];
        int i = 0;

        while (p <= m && q <= r) {
            if (arr[p] <= arr[q]) {
                tmp[i++] = arr[p++];
            } else {
                res += m - p + 1;
                tmp[i++] = arr[q++];
            }
        }

        while (p <= m) tmp[i++] = arr[p++];
        while (q <= r) tmp[i++] = arr[q++];

        for (int val : tmp) arr[l++] = val;
        return res;
    }


}
