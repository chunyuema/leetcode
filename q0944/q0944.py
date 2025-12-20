class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        res = 0
        for col in range(len(strs[0])):
            # start iterating from the second row 
            # ensure the presence of a prev char
            for row in range(1, len(strs)):
                curr = strs[row][col]
                prev = strs[row-1][col]
                # if prev > curr, then delete the whole col
                # break early to move to the next col
                if prev > curr: 
                    res += 1
                    break
        return res
