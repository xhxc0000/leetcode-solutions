class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int min = 0;
        int remain = 0;
        int minRemain = Integer.MAX_VALUE;

        for (int i = 0; i < gas.length; i++) {
            remain += gas[i] - cost[i];
            if (remain < minRemain) {
                min = i;
                minRemain = remain;
            }
        }
        return remain < 0 ? -1 : (min + 1) % gas.length;
    }
}
