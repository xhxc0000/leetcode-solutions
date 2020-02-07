class Solution {

    private List<List<String>> res = new ArrayList<>();
    private LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        dfs(s, 0);

        return res;
    }

    private void dfs(String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (!isPalindrome(s, start, i)) continue;
            path.add(s.substring(start, i + 1));  // sub[start, i]
            dfs(s, i + 1);
            path.removeLast();
        }
    }

    private boolean isPalindrome(String s, int L, int R) {
        while (L <= R) {
            if (s.charAt(L) == s.charAt(R)) {
                L++; R--;
            } else {
                return false;
            }
        }

        return true;
    }

    // dp优化版本
    public List<List<String>> partition(String s) {
        // init
        int len = s.length();
        this.f = new boolean[len][len];
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || f[i + 1][j - 1])) f[i][j] = true;
            }
        }
        dfs(s, 0);

        return res;
    }
}
