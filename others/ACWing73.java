class Solution {

    // map 解法
    public int[] findNumsAppearOnce(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : arr) map.put(val, map.getOrDefault(val, 0) + 1);
        
        int[] res = new int[2];
        int i = 0;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> ent : entries) {
            if (ent.getValue() == 1) res[i++] = ent.getKey();
        }
        
        return res;
    }

    // 空间O(1)解法
    public int[] findNumsAppearOnce(int[] arr) {
        int xor = 0;
        for (int val : arr) xor ^= val;
        
        // split
        int k = 0;
        while ((xor >> k & 1) == 0) k++;
        int a = 0;
        for (int val : arr) {
            if ((val >> k & 1) > 0) a ^= val;
        }
        
        return new int[] {a, xor ^ a};
    }
}
