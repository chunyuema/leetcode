class Solution:
    def findAllPeople(self, n: int, meetings: List[List[int]], firstPerson: int) -> List[int]:
        graph = defaultdict(list)
        for (p1, p2, time) in meetings: 
            graph[p1].append((p2, time))
            graph[p2].append((p1, time))
        
        # Initialize the priority queue (based on the meeting time)
        pq = [(0, firstPerson)]
        for (person, time) in graph[0]: heappush(pq, (time, person))
        
        # Initialize the list of people who holds secrets
        secretHolders = set([0])
        while pq:
            # Greedily grab the earliest person who will hold secret next
            secretHoldingTime, currPerson = heappop(pq)

            # Add the person to the secret holders if they have not been added
            if currPerson in secretHolders: continue
            secretHolders.add(currPerson)

            # BFS on their neighbors to identify
            for (nextPerson, meetingTime) in graph[currPerson]: 
                if secretHoldingTime <= meetingTime:
                    heappush(pq, (meetingTime, nextPerson))
        return secretHolders