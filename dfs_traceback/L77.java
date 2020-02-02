class Solution {

    private List<List<Integer>> res = new LinkedList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    private int n;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        dfs(k, 1);

        return res;
    }

    private void dfs(int remain, int start) {
        if (remain == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // enumerate
        for (int i = start; i <= n - remain + 1; i++) {
            // store
            path.add(i);
            dfs(remain - 1, i + 1);
            // restore
            path.removeLast();
        }
    }
}
