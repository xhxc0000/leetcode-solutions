class Solution {
    public int moreThanHalfNum_Solution(int[] arr) {
        int rep = arr[0];
        int supports = 0;
        
        for (int val : arr) {
            if (val == rep) {
                supports++;
            } else {
                supports--;
                if (supports <= 0) {
                    rep = val;
                    supports = 1;
                }
            }
        }
        
        return rep;
    }
}
