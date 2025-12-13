class Solution:
    def validateCoupons(self, code: List[str], businessLine: List[str], isActive: List[bool]) -> List[str]:
        res = []
        valid_code = re.compile(r'^[A-Za-z0-9_]+$')
        valid_business = set(["electronics", "grocery", "pharmacy", "restaurant"])
        for i, c in enumerate(code):
            b = businessLine[i]
            if (valid_code.match(c) and 
                b in valid_business and
                isActive[i]):
                res.append([b, c])
        
        res.sort(key = lambda item : (item[0], item[1]))
        return [c for [b, c] in res]
