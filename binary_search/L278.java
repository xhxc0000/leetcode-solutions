/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int L = 1, R = n;
        while (L < R) {
            int mid = L + R >>> 1;
            if (isBadVersion(mid)) R = mid;
            else L = mid + 1;
        }

        return L;     
    }
}
