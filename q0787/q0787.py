class Solution:

    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        # Build graph based on the flights information
        graph = defaultdict(list)
        for (start, end, price) in flights:
            graph[start].append((end, price))

        # Track the cheapest price to all the nodes
        cheapestPrices = [float('inf') for _ in range(n)]
        queue = deque([(src, 0)])

        # When there is still nodes to explore, and stops to use 
        while queue and k >= 0: 
            
            # BFS to explore all the cities of k hops from src
            for _ in range(len(queue)):
                currCity, priceToCity = queue.popleft(); 

                # Explore next city only if it makes sense (less than current cheapest price)
                for (nextCity, nextCityPrice) in graph[currCity]:
                    priceToNextCity = priceToCity + nextCityPrice
                    if priceToNextCity <= cheapestPrices[nextCity]:
                        queue.append((nextCity, priceToNextCity))
                        cheapestPrices[nextCity] = priceToNextCity
            
            k -= 1
        
        return -1 if cheapestPrices[dst] == float('inf') else cheapestPrices[dst]