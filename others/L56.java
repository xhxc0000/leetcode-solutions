class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length < 1) return res.toArray(new int[0][]);

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int l = intervals[0][0], r = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > r) {
                res.add(new int[] {l ,r});
                l = intervals[i][0];
                r = intervals[i][1];
            } else {
                r = Math.max(r, intervals[i][1]);
            }
        }

        res.add(new int[] {l ,r});

        return res.toArray(new int[0][]);
    }
}
