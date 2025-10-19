class Solution:
    def findLexSmallestString(self, s: str, a: int, b: int) -> str:
        visited = set()
        stack = [s]
        minStr = s
        
        while stack:
            curr = stack.pop()
            if curr in visited:
                continue
            visited.add(curr)
            if curr < minStr:
                minStr = curr

            # Operation 1: Add 'a' to all digits at odd indices
            chars = list(curr)
            for i in range(1, len(s), 2):
                chars[i] = str((int(chars[i]) + a) % 10)
            added = ''.join(chars)
            stack.append(added)

            # Operation 2: Rotate by b
            rotated = curr[-b:] + curr[:-b]
            stack.append(rotated)

        return minStr

