class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    private boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] arr) {
        if (arr.length < 1) return res;
        Arrays.sort(arr);
        this.visited = new boolean[arr.length];
        dfs(arr, 0);

        return res;
    }

    private void dfs(int[] arr, int index) {
        if (index == arr.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) continue; // 因为是枚举每个位置放哪个元素, i - 1访问过, 说明i - 1在其他位置

            // store
            path.add(arr[i]);
            visited[i] = true;
            dfs(arr, index + 1);
            //  restore
            visited[i] = false;
            path.removeLast();
        }
    }
}
