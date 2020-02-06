class Solution {
    public int longestConsecutive(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int val : arr) set.add(val);
        int max = 0;

        for (int val : arr) {
            int count = 1;
            int cur = val;
            while (set.remove(++cur)) count++;
            cur = val;
            while (set.remove(--cur)) count++;
            if (count > max) max = count;
        }

        return max;
    }
}
