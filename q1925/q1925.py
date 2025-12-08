class Solution:
    def countTriples(self, n: int) -> int:
        res = 0
        for a in range(1, n):
            for b in range(i+1, n):
                sqr = (i ** 2) + (j ** 2)
                c = math.isqrt(sqr_sum)
                if c ** 2 == sqr_sum and c <= n:
                    res += 1 
        # position of a and b can be inversed
        return res * 2
