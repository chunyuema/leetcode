class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        stack = []
        for i in range(len(s)):
            c = s[i]
            if c == ')' and (stack and s[stack[-1]] == '('): stack.pop()
            elif (c == '(' or c == ')'): stack.append(i)
        
        res = []
        for i in range(len(s)):
            if stack and stack[0] == i: 
                stack.pop(0)
                continue
            res.append(s[i])
        return "".join(res)