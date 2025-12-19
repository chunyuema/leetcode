class Solution:
    def findAllPeople(self, n: int, meetings: List[List[int]], firstPerson: int) -> List[int]:
        # Build graph with weighted edges
        graph = defaultdict(list)
        for p1, p2, time in meetings: 
            graph[p1].append((p2, time))
            graph[p2].append((p1, time))

        # Visited set to track all the persons that the secret will reach
        secrets_holder = set([0])
        
        # Priority queue with the first person to be shared with the secret
        # Sort by time on the pq, to ensure that earlier ones are processed first
        pq = [(0, firstPerson)]
        for person, time in graph[0]: 
            heappush(pq, (time, person))

        # Performe Dijkstra algorithm to find all people reachable
        while pq:
            # Extend from the meeting with the earliest time to start
            curr_time, curr_person = heappop(pq)

            # If the curr person has been visited, skip
            if curr_person in secrets_holder: continue

            # If the curr person has not been visisted, mark it as visited
            # Add its neighbors to the priority queue
            secrets_holder.add(curr_person)
            for next_person, next_time in graph[curr_person]: 
                if curr_time <= next_time:
                    heappush(pq, (next_time, next_person))
        
        return list(visited)
