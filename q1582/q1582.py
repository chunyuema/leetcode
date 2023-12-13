class Solution:
    def numSpecial(self, mat: List[List[int]]) -> int:
        r, c = len(mat), len(mat[0])
        rowRecord = [0] * r
        colRecord = [0] * c
        for i in range(r): 
            for j in range(c): 
                if mat[i][j] == 1:
                    rowRecord[i] += 1
                    colRecord[j] += 1
        
        res = 0
        for i in range(r): 
            for j in range(c): 
                if mat[i][j] == 1 and rowRecord[i] == 1 and colRecord[j] == 1:
                    res += 1
        return res