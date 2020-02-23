class Solution {
    public void reverseString(char[] s) {
        int L = 0, R = s.length - 1;
        while (L < R) {
            char tmp = s[L];
            s[L++] = s[R];
            s[R--] = tmp;
        }
    }
}
