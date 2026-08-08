

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // Edge case: zero numerator
        if (numerator == 0) {
            return "0";
        }
        
        StringBuilder res = new StringBuilder();
        
        // 1. Determine the sign using XOR
        // If one is negative and the other is positive, append '-'
        if (numerator < 0 ^ denominator < 0) {
            res.append("-");
        }
        
        // 2. Convert to long to prevent overflow with Integer.MIN_VALUE
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        // 3. Calculate integer part
        res.append(num / den);
        long rem = num % den;
        
        // If there is no fractional part, return early
        if (rem == 0) {
            return res.toString();
        }
        
        // 4. Calculate fractional part
        res.append(".");
        
        // Maps remainder -> index in the StringBuilder
        Map<Long, Integer> map = new HashMap<>();
        
        while (rem != 0) {
            // If we've seen this remainder before, a repeating cycle starts
            if (map.containsKey(rem)) {
                res.insert(map.get(rem), "(");
                res.append(")");
                break;
            }
            
            // Store the current length of the result as the index for this remainder
            map.put(rem, res.length());
            
            // Simulate long division
            rem *= 10;
            res.append(rem / den);
            rem %= den;
        }
        
        return res.toString();
    }
}