class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        if (arr.length < 2) return res;

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            if (arr[i] > 0) break;

            int L = i + 1, R = arr.length - 1;
            while (L < R) {
                int sum = arr[i] + arr[L] + arr[R];
                if (sum == 0) {
                    res.add(Arrays.asList(arr[i], arr[L], arr[R]));
                    while (L < R && arr[L] == arr[L + 1]) L++;
                    while (L < R && arr[R] == arr[R - 1]) R--;
                    L++; R--;
                } else if (sum > 0) {
                    R--;
                } else if (sum < 0) {
                    L++;
                }
            }
        }

        return res; 
    }
}
