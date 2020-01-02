class Solution {
    public int[] multiply(int[] A) {
        if (A.length < 1) return A;
        
        int[] B = new int[A.length];
        
        for (int i = 0, p = 1; i < A.length; i++) {
            B[i] = p;
            p *= A[i];
        }
        
        for (int i = A.length - 1, p = 1; i >= 0; i--) {
            B[i] *= p;
            p *= A[i];
        }
        
        return B;
    }
}
