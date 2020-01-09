class Solution {
    public String replaceSpaces(StringBuffer s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') count++;
        }
        
        int j = s.length() - 1, i = j + count * 2;
        s.setLength(i + 1);
        
        while (j >= 0) {
            if (s.charAt(j) != ' ') {
                s.setCharAt(i--, s.charAt(j--));
            } else {
                s.setCharAt(i--, '0');
                s.setCharAt(i--, '2');
                s.setCharAt(i--, '%');
                j--;
            }
        }
        
        return s.toString();
    }
}
