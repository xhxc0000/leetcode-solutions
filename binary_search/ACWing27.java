class Solution {
    public double Power(double base, int exponent) {
        if (base == 0) return 0;
        if (exponent == 0) return 1;
        if (exponent > 0) {
            return pow(base, exponent);
        } else {
            return pow(1 / base, exponent * -1);
        }
    }
    
    private double pow(double base, int exp) {
        if (exp == 1) return base;
        if (exp == 0) return 1;
        
        double res = pow(base, exp / 2);
        res *= res;
        if ((exp & 1) == 1) res *= base;
        
        return res;
    }
  
  
}
