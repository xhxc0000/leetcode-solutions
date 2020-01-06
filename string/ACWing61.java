class Solution {
    public int longestSubstringWithoutDuplication(String s) {
        int[] hash = new int[26];
        char[] arr = s.toCharArray();
        
        int res = 0;
    
        for (int i = 0, j = 0; i < arr.length; i++) {
            hash[arr[i] - 'a']++;
            while (j < i && hash[arr[i] - 'a'] > 1) hash[arr[j++] - 'a']--;
            res = Math.max(res, i - j + 1);
        }
        
        return res;
    }
}
