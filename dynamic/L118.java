class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> level = new ArrayList<>();
            List<Integer> pre = i == 0 ? null : res.get(i - 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    level.add(1);
                    continue;
                } else {
                    level.add(pre.get(j) + pre.get(j - 1));
                }
            }
            res.add(level);
        }

        return res;
    }
}
