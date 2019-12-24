import java.util.*;
class Solution {
    public boolean isHappy(int n) {
        int slow = squareSum(n), fast = squareSum(squareSum(n));
        while (slow != fast) {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        }

        return slow == 1;
    }

    private int squareSum(int n) {
        int res = 0;
        while (n > 0) {
            int tmp = n % 10;
            res += tmp * tmp;
            n /= 10;
        }

        return res;
    }
}
