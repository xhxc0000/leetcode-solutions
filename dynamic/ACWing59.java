class Solution {
    public int getTranslationCount(String s) {
        char[] arr = s.toCharArray();
        int f[] = new int[arr.length + 1];
        f[0] = 1;
        f[1] = 1;
        
        for (int i = 2; i <= arr.length; i++) {
            if (arr[i - 2] == '1') f[i] = f[i - 2] + f[i - 1];
            else if (arr[i - 2] == '2' && arr[i - 1] >= '0' && arr[i - 1] <= '5') f[i] = f[i - 2] + f[i - 1];
            else f[i] = f[i - 1];
        }
        
        return f[arr.length];
    }
}
