class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        final_index_map = {char: i for i, char in enumerate(s)}
        visited = set()
        stack = []
        for i, char in enumerate(s):
            if char not in visited:
                while stack and stack[-1] > char and i < final_index_map[stack[-1]]:
                    visited.remove(stack[-1])
                    stack.pop()
                stack.append(char)
                visited.add(char)
        return "".join(stack)
