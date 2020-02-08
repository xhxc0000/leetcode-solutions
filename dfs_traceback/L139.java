class Solution {
    private Set<String> set = new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        for (String str : wordDict) set.add(str);
        return dfs(s, 0);
    }

    private boolean dfs(String s, int start) {
        if (start == s.length()) {
            return true;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            if (!set.contains(s.substring(start, i))) continue;

            if (dfs(s, i)) return true;
        }
        return false;
    }
}
