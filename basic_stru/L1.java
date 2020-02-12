class Solution {
    public int[] twoSum(int[] arr, int target) {
        // index -> val
        Map<Integer, Integer> map = new HashMap<>((int)(arr.length / 0.75F + 1.0F));
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                return new int[] {map.get(target - arr[i]), i};
            }
            map.put(arr[i], i);
        }

        return new int[] {-1, -1};
    }
}
