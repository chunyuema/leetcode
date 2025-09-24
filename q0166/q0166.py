class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        if numerator == 0: return "0"
        result_sign = "-" if (numerator < 0) ^ (denominator < 0) else ""
        numerator, denominator = abs(numerator), abs(denominator)

        pre = str(numerator // denominator)
        remainder = numerator % denominator

        if remainder == 0: return result_sign + pre  # No fractional part

        post = ""
        remainder_map = {}  # remainder -> position in post
        while remainder != 0 and remainder not in remainder_map:
            remainder_map[remainder] = len(post)
            remainder *= 10
            post += str(remainder // denominator)
            remainder %= denominator
        
        if remainder != 0:
            repeatingLen = remainder_map[remainder]
            nonrepeating = post[:repeatingLen]
            repeating = post[repeatingLen:]
            return result_sign + pre + "." + nonrepeating + "(" + repeating + ")"
        return result_sign + pre + "." + post