class Solution {
    public int[] printMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m < 1) return new int[0];
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int index = 0;        
        int tR = 0, tC = 0, dR = m - 1, dC = n - 1;
        System.out.println("m:" + m + " n:" + n);
      
        while (tR <= dR && tC <= dC) {
            for (int i = tC; i <= dC; i++) res[index++] = matrix[tR][i];
            for (int i = tR + 1; i <= dR; i++) res[index++] = matrix[i][dC];
            
            if (tR != dR) {
                for (int i = dC - 1; i >= tC; i--) res[index++] = matrix[dR][i];    
            }
            if (tC != dC) {
                for (int i = dR - 1; i > tR; i--) res[index++] = matrix[i][tC];    
            }
            
            tR++; tC++; dR--; dC--;
        }
        
        return res;
    }
}
