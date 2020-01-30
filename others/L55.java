class Solution {
    public boolean canJump(int[] arr) {
        int area = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i > area) return false;
            area = Math.max(area, i + arr[i]);
        }

        return true;
    }
}
