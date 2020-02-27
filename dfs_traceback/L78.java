class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] arr) {
        if (arr.length < 1) return res;
        dfs(arr, 0);
        return res;
    }

    private void dfs(int[] arr, int index) {
        if (index == arr.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        path.add(arr[index]);
        dfs(arr, index + 1);
        path.removeLast();
        dfs(arr, index + 1);
    }

	public List<List<Integer>> subsets(int[] arr) {
        if (arr.length < 1) return res;

        for (int i = 0; i < 1 << arr.length; i++) {
            List<Integer> path = new ArrayList<>();
            for (int j = 0; j < arr.length; j++) {
                if ((i >> j & 1) == 1) path.add(arr[j]);
            }
            res.add(path);
        }
        return res;
    }
}
