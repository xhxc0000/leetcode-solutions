import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] param = reader.readLine().split(" ");
        int len = Integer.parseInt(param[0]);
        int k = Integer.parseInt(param[1]);
        String[] str =a reader.readLine().split(" ");
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) arr[i] = Integer.parseInt(str[i]);
        int res = quickSort(arr, 0, arr.length - 1, k);
        System.out.println(res);
        reader.close();
    }

    // if size(left_inverval >= k) quick left_interval
    // if  < k then quick right_interval
    // finally size_of_interval is 1 --> res
    private static int quickSort(int[] arr, int l, int r, int k) {
        if (l == r) return arr[l];

        // partition
        int pivot = arr[l + r >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            while (arr[++i] < pivot);
            while (arr[--j] > pivot);
            if (i < j) swap(arr, i, j);
        }

        if (j - l + 1 >= k) return quickSort(arr, l, j, k);
        else return quickSort(arr, j + 1, r, k - (j - l + 1));
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
