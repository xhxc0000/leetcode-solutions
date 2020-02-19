class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int val : nums1) set.add(val);

        Set<Integer> dupSet = new HashSet<>();
        for (int val : nums2) {
            if (set.contains(val)) dupSet.add(val);
        }

        int[] res = new int[dupSet.size()];
        int i = 0;
        for (int val : dupSet) res[i++] = val;


        return res;
    }
}
