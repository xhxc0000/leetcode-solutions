class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    private LinkedList<Integer> path = new LinkedList<>();
    private int[] cand;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length < 1) return res;
        this.cand = candidates;
        Arrays.sort(cand);
        dfs(target, 0);

        return res;
    }

    private void dfs(int remain, int start) {
        if (remain == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // list
        for (int i = start; i < cand.length; i++) {
            if (remain - cand[i] < 0) break;
            // store
            path.add(cand[i]);
            dfs(remain - cand[i], i);
            //restore
            path.removeLast();
        }
    }
}
