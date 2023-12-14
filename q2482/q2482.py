class Solution:
    def onesMinusZeros(self, grid: List[List[int]]) -> List[List[int]]:
        r, c = len(grid), len(grid[0])
        rowOneCount = [0] * r
        rowZeroCount = [0] * r
        colOneCount = [0] * c
        colZeroCount = [0] * c

        for i in range(r): 
            for j in range(c): 
                if grid[i][j] == 1: 
                    rowOneCount[i] += 1
                    colOneCount[j] += 1
                else: 
                    rowZeroCount[i] += 1
                    colZeroCount[j] += 1
        
        diff = [[0] * c for _ in range(r)]
        for i in range(r): 
            for j in range(c): 
                diff[i][j] = rowOneCount[i] + colOneCount[j] - rowZeroCount[i] - colZeroCount[j]
            
        return diff
        