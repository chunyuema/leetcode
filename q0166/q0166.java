package q0166;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        if (denominator == 0)
            return "0";

        StringBuilder res = new StringBuilder();
        String sign = (numerator < 0) ^ (denominator < 0) ? "-" : "";
        res.append(sign);

        Long num = Math.abs((long) numerator);
        Long denom = Math.abs((long) denominator);
        res.append(String.valueOf(num / denom));
        Long remainder = num % denom;
        if (remainder == 0)
            return res.toString();
        res.append(".");

        Map<Long, Integer> observedRemainder = new HashMap<>();

        while (remainder != 0 && !observedRemainder.containsKey(remainder)) {
            observedRemainder.put(remainder, res.length());
            remainder *= 10;
            res.append(String.valueOf(remainder / denom));
            remainder %= denom;
        }

        if (remainder != 0) {
            return res.insert(observedRemainder.get(remainder), "(").append(")").toString();
        }

        return res.toString();
    }
}
