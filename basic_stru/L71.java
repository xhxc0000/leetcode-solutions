class Solution {
    public String simplifyPath(String path) {
        if (path.length() < 1) return path;
        StringBuilder res = new StringBuilder();
        Stack<String> stack = new Stack<>();
        String[] s = path.split("/");

        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("") || s[i].equals(".")) {
                continue;
            } else if (s[i].equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(s[i]);
            }
        }

        if (stack.isEmpty()) {
            res.append("/");
        } else {
            for (int i = 0; i < stack.size(); i++) {
                res.append("/").append(stack.get(i));
            }
        }

        return res.toString();
    }
}
