class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long num = numerator, den = denominator;
        String sign = "";
        if ((num > 0 && den < 0) || (num < 0 && den > 0)) {
            sign = "-";
        }
        num = Math.abs(num); den = Math.abs(den);
        long integer = num / den;
        num -= integer * den;
        if (num == 0) return sign + integer;

        // 处理小数
        String decimal = "";
        Map<Long, Integer> map = new HashMap<>();
        int index = 0, repeatIndex = -1;
        while (num != 0) {
            num *= 10;
            if (map.containsKey(num)) {
                repeatIndex = map.get(num);
                break;
            }
            map.put(num, index++);
            long dec = num / den; decimal += dec;
            num -= dec * den;
        }
        
        if (repeatIndex == -1) {
            // case no loop
            return sign + integer + "." + decimal;
        } else {
            return sign + integer + "." + decimal.substring(0, repeatIndex) + "(" + decimal.substring(repeatIndex) + ")";
        }
    }
}
