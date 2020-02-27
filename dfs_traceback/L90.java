class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] arr) {
        if (arr.length < 1) return res;
        Arrays.sort(arr);
        dfs(arr, 0);

        return res;
    }

    private void dfs(int[] arr, int index) {
        if (index == arr.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        int k = index;
        while (k < arr.length && arr[k] == arr[index]) k++;
        k -= index;

        dfs(arr, index + k); // 枚举不添加arr[index]的情况
        for (int i = 1; i <= k; i++) {
            path.add(arr[index]);
            dfs(arr, index + k);
        }

        // remove
        for (int i = 1; i <= k; i++) path.removeLast();
    }
}
