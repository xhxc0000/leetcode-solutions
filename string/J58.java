class Solution {
    public int lengthOfLastWord(String s) {
        int r = s.length() - 1;
        // r定位到首个非空格字符
        while (r >= 0 && s.charAt(r) == ' ') r--;
        if (r < 0) return 0;
        int l = r;
        while (l >= 0 && s.charAt(l) != ' ') l--;
        return r - l;
    }
}
