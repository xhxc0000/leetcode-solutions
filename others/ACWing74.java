class Solution {
    public int findNumberAppearingOnce(int[] arr) {
        int a = 0, b = 0;
        for (int x : arr) {
            a = (a ^ x) & ~b;
            b = (b ^ x) & ~a;
        }
        
        return a;
    }
}
