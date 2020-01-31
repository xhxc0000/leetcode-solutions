class Solution {
    public int jump(int[] arr) {
        int steps = 0, maxPosi = 0, end = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            maxPosi = Math.max(maxPosi, i + arr[i]);
            if (i == end) {
                end = maxPosi;
                steps++;
            }
        }
        
        return steps;
    }
}
