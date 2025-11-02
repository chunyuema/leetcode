class Solution:
    def countUnguarded(self, m: int, n: int, guards: List[List[int]], walls: List[List[int]]) -> int:
        graph = [[1 for _ in range(n)] for _ in range(m)]

        # mark the walls to be -1
        for i, j in walls: graph[i][j] = -1
        
        # mark the guards to be -2
        for i, j in guards: graph[i][j] = -2

        # mark the guarded cells 
        for i, j in guards: self.markGuarded(i, j, graph)
        
        count = 0
        for i in range(m): 
            for j in range(n):
                if graph[i][j] == 1: 
                    count += 1
        return count 

    
    # eager termination needed to avoid TLE: 
    # if you see a wall, guard cannot see beyond the wall, terminate
    # if you see another guard, the cells beyond that guard will be covered when checking that guard
    # this is because we mark guarded cells by extending from the center 
    def markGuarded(self, i, j, graph):
        up = i - 1
        while up >= 0 and graph[up][j] != -1 and graph[up][j] != -2: 
            graph[up][j] = 0
            up -= 1

        down = i + 1
        while down < len(graph) and graph[down][j] != -1 and graph[down][j] != -2:
            graph[down][j] = 0
            down += 1

        left = j - 1
        while left >= 0 and graph[i][left] != -1 and graph[i][left] != -2:
            graph[i][left] = 0
            left -= 1
        
        right = j + 1 
        while right < len(graph[0]) and graph[i][right] != -1 and graph[i][right] != -2: 
            graph[i][right] = 0
            right += 1
