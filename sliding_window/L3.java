class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int max = 0;
        int[] hash = new int[256];
        while (right < s.length()) {
            char c = s.charAt(right);
            if (hash[c] < 1) {
                hash[c]++;
                right++;
                max = Math.max(max, right - left);
            } else {
                while (left < right && s.charAt(left) != c) {
                    hash[s.charAt(left)]--;
                    left++;
                }
                left++;
                right++;
            }
        }

        return max;
    }
}
