class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 处理特殊情况
        if (newInterval.length < 1) return intervals; 
        if (intervals.length < 1) {
            int[][] res = {newInterval};
            return res;
        }
        LinkedList<int[]> res = new LinkedList<>();
        // add  intervals before newInterval's start
        int i = 0;
        while (i < intervals.length && intervals[i][0] <= newInterval[0]) res.add(intervals[i++]);

        // add newInterval
        if (res.isEmpty() || res.peekLast()[1] < newInterval[0]) {
            res.add(newInterval);
        } else {
            // case 重叠
            res.peekLast()[1] = Math.max(newInterval[1], res.peekLast()[1]);
        }

        // 合并重叠区间
        while (i < intervals.length && intervals[i][0] <= res.peekLast()[1]) {
            res.peekLast()[1] = Math.max(intervals[i][1], res.peekLast()[1]);
            i++;
        }

        // 添加非重叠区间
        while (i < intervals.length) res.add(intervals[i++]);

        return res.toArray(new int[0][]);
    }
}
