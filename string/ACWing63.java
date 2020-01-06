class Solution {
    public char firstNotRepeatingChar(String s) {
        int[] hash = new int[256];
        char[] arr = s.toCharArray();
        
        for (int i = 0; i < s.length(); i++) hash[arr[i]]++;
        
        for (char c : arr) {
            if (hash[c] == 1) return c;
        }
        
        return '#';
    }
}
