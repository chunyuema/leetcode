class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.pq = []
        self.k = k
        for num in nums: 
            self.add(num)
            
    def add(self, val: int) -> int:
        heappush(self.pq, val)
        while len(self.pq) > self.k:
            heappop(self.pq)        
        return self.pq[0]

