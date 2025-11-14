class Solution:
    def rangeAddQueries(self, n: int, queries: List[List[int]]) -> List[List[int]]:
        # Build the difference array of the matrix
        diff = [[0] * (n + 1) for _ in range(n + 1)]
        for r1, c1, r2, c2 in queries:
            diff[r1][c1] += 1
            diff[r1][c2+1] -= 1
            diff[r2+1][c1] -= 1
            diff[r2+1][c2+1] += 1
    
        # Rebuild the matrix using the difference matrix
        matrix = [[0] * n for _ in range(n)]
        for i in range(n):
            for j in range(n):
                x1 = 0 if i == 0 else matrix[i-1][j]
                x2 = 0 if j == 0 else matrix[i][j-1]
                x3 = 0 if i == 0 or j == 0 else matrix[i-1][j-1]
                matrix[i][j] = diff[i][j] + x1 + x2 - x3
        return matrix
