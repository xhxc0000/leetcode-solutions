class Solution {
    public int majorityElement(int[] arr) {
        int proposal = arr[0], agree = 0;
        for (int val : arr) {
            if (proposal == val) agree++;
            else agree--;

            if (agree < 0) {
                proposal = val;
                agree = 1;
            }
        }

        return proposal;
    }
}
