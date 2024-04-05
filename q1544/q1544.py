class Solution:
    def makeGood(self, s: str) -> str:
        stack = []
        for c in s: 
            # Check if the incoming character will result in a bad pair
            if len(stack) != 0 and (c != stack[-1] and c.lower() == stack[-1].lower()): 
                # Do not add incoming char, and remove the previous char too
                stack.pop()
            else: 
                stack.append(c)
        
        return "".join(stack)