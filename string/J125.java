class Solution {
    public boolean isPalindrome(String s) {
        int L = 0, R = s.length() - 1;
        while (L < R) {
            while (L < s.length() && !isTarget(s.charAt(L))) L++;
            while (R >= 0 && !isTarget(s.charAt(R))) R--;
            // System.out.print("L:" + s.charAt(L) + " R:" + s.charAt(R));
            if (L < R) {
                if (!equals(s.charAt(L), s.charAt(R))) return false;
                L++; R--;
            } else {
                return true;
            }
        }

        return true;
    }

    private boolean isTarget(char c) {
        return isLetter(c) || isNumber(c);
    }

    private boolean equals(char c1, char c2) {
        if (isNumber(c1) && isNumber(c2)) return c1 == c2;
        else return isCharEquals(c1, c2);
    }

    private boolean isCharEquals(char c1, char c2) {
        if ('a' <= c1 && c1 <= 'z') c1 -= 32;
        if ('a' <= c2 && c2 <= 'z') c2 -= 32;

        return c1 == c2;
    }
    private boolean isLetter(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }

    private boolean isNumber(char c) {
        return '0' <= c && c <= '9';
    }
}
