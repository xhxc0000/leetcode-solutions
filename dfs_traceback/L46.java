class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    private boolean visited[];
    public List<List<Integer>> permute(int[] arr) {
        if (arr.length < 1) return res;
        this.visited = new boolean[arr.length];
        dfs(arr, 0);
        return res;
    }

    private void dfs(int[] arr, int len) {
        if (len == arr.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        // enumeration
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                // store
                path.add(arr[i]);
                visited[i] = true;
                dfs(arr, len + 1);
                // restore
                visited[i] = false;
                path.removeLast();
            }
        }
    }
}
