class Solution {
    public int strToInt(String str) {
        String s = str.trim();
        if (s.isEmpty()) return 0;
        
        boolean isMinus = false;
        int index = 0;
        long num = 0;
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            isMinus = s.charAt(index) == '-';
            index++;
        }
        
        while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            num = num * 10 + s.charAt(index) - '0';
            index++;
        }
        
        if (isMinus) num *= -1;
        
        num = Math.min(num, Integer.MAX_VALUE);
        num = Math.max(num, Integer.MIN_VALUE);
        
        return (int)num;
    }
}
