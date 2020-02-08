class Solution {
    public int singleNumber(int[] arr) {
        int one = 0, two = 0;
        for (int val : arr) {
            one = one ^ val & ~two;
            two = two ^ val & ~one;
        }

        return one;
    }
}
