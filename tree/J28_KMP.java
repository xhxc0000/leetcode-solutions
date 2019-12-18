class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() < 1) return 0;
        int[] LPS = getLPS(needle);

        int i = 0, j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++; j++;
                if (j == needle.length()) return i - needle.length();
            } else if (j > 0) {
                j = LPS[j - 1];
            } else {
                i++;
            }
        }

        return -1;
    }

    private int[] getLPS(String p) {
        int[] LPS = new int[p.length()];

        int i = 1, len = 0;
        while (i < p.length()) {
            if (p.charAt(i) == p.charAt(len)) {
                LPS[i++] = ++len;
            } else if (len > 0) {
                len = LPS[len - 1];
            } else {
                i++;
            }
        }

        return LPS;
    }
}
