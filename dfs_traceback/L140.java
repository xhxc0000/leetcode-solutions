class Solution {
    private List<String> res = new ArrayList<>();
    private List<String> path = new ArrayList<>();
    private Set<String> set = new HashSet<>();
    private boolean[] f;
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.f = new boolean[s.length() + 1];
        for (String str : wordDict) set.add(str);
        f[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && set.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }

        if (!f[s.length()]) return res;
        dfs(s, s.length());

        return res; 
    }

    private void dfs(String s, int end) {
        if (end == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = path.size() - 1; i >= 0; i--) sb.append(path.get(i)).append(" ");
            res.add(sb.deleteCharAt(sb.length() - 1).toString());
            return;
        }

        for (int i = end - 1; i >= 0; i--) {
            if (f[i] && set.contains(s.substring(i, end))) {
                path.add(s.substring(i, end));
                dfs(s, i);
                path.remove(path.size() - 1);
            }
        }
    }


}
