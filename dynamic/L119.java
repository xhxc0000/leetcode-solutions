class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            int pre = 1, cur = 0;
            for (int j = 1; j <= i; j++) {
                if (j == i) {
                    res.add(1);
                } else {
                    cur = res.get(j);
                    res.set(j, res.get(j) + pre);
                    pre = cur;
                }
            }
        }

        return res;
    }
}
