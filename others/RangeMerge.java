import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class IntervalMerge {
    public static void main(String[] args) {
        int[][] ran = new int[][] {{1, 2}, {2, 4}, {5, 6}, {7, 8}, {7, 9}};
        Arrays.sort(ran, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] -o2[0];
            }
        });

        List<Range> list = new ArrayList<>();
        for (int i = 0; i < ran.length; i++) list.add(new Range(ran[i][0], ran[i][1]));
        List<Range> res = merge(list);
        System.out.println(res.size());

    }

    private static List<Range> merge(List<Range> list) {
        List<Range> res = new ArrayList<>();
        if (list.size() < 1) return res;
        Range cur = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Range tmp = list.get(i);
            if (cur.r >= tmp.l) {
                cur.r = Math.max(cur.r, tmp.r);
            } else {
                res.add(cur);
                cur = tmp;
            }
        }
        res.add(cur);

        return res;
    }

    private static int merge(int[][] range) {
        int res = 0;

        for (int i = 0, r = Integer.MIN_VALUE; i < range.length; i++) {
            if (r >= range[i][0]) {
                r = Math.max(r, range[i][1]);
            } else {
                res++;
                r = range[i][1];
            }
        }

        return res;
    }

    static class Range{
        int l;
        int r;

        public Range(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
}
