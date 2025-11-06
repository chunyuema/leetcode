class Solution:
    def processQueries(self, c: int, connections: List[List[int]], queries: List[List[int]]) -> List[int]:
        stationInfo = {}       # station -> [active (0/1), componentId]
        componentInfo = {}     # componentId -> min-heap of stations to quickly find out the min of the next one online
        self.buildInfo(c, connections, queries, stationInfo, componentInfo)

        answer = []
        for op, s in queries:
            compId = stationInfo[s][1]
            stations = componentInfo[compId]

            if op == 2:  # deactivate station
                stationInfo[s][0] = 0

            elif op == 1:  # query for smallest active station
                if stationInfo[s][0] == 1:
                    answer.append(s)
                else:
                    # Pop inactive stations from heap top until smallest active is on top
                    while stations and stationInfo[stations[0]][0] == 0: heapq.heappop(stations)
                    if stations: answer.append(stations[0])
                    # If no stations left / all offline, append -1
                    else: answer.append(-1)
        return answer
    
    def buildInfo(self, c, connections, queries, stationInfo, componentInfo):
        # Build the graph
        graph = defaultdict(list)
        for u, v in connections:
            graph[u].append(v)
            graph[v].append(u)  # assuming undirected graph
        
        # Assign stations to components using DFS
        componentId = 1
        visited = set()
        for station in range(1, c + 1):
            if station in visited:
                continue
            stack = [station]
            heap = []
            while stack:
                s = stack.pop()
                if s in visited:
                    continue
                visited.add(s)
                stationInfo[s] = [1, componentId]  # active, component ID
                heapq.heappush(heap, s)
                for n in graph[s]:
                    if n not in visited:
                        stack.append(n)
            componentInfo[componentId] = heap
            componentId += 1

