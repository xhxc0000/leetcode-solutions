class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(res, "", s, 0, 4);

        return res;
    }

    private void dfs(List<String> res, String path, String s, final int start, final int remain) {
        if (start == s.length()) {
            if (remain == 0) res.add(path.substring(0, path.length() - 1));
            return;
        }
        // 剪枝
        if (s.length() - start >= remain * 4 || s.length() - start < remain) return;

        // 取1位
        dfs(res, path + s.substring(start, start + 1) + ".", s, start + 1, remain - 1);
        if (s.charAt(start) == '0') return;
        // 取2位
        if (s.length() - start >= 2) {
            dfs(res, path + s.substring(start, start + 2) + ".", s, start + 2, remain - 1);
        }
        // 取3位
        if (s.length() - start >= 3) {
            int append = Integer.parseInt(s.substring(start, start + 3));
            if (append >= 256) return;
            dfs(res, path + append + ".", s, start + 3, remain - 1);
        }
    }
}
