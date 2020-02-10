class Solution {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            int c = n % 26;
            if (c == 0) {
                c = 26;
                n -= 26;
            }
            res.append((char)('A' - 1 + c));
            n /= 26;
        }

        return res.reverse().toString();
    }
}
