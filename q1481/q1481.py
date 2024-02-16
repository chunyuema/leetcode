class Solution:
    def findLeastNumOfUniqueInts(self, arr: List[int], k: int) -> int:
        numCount = Counter(arr)
        counts = sorted(list(numCount.values()))
        res = len(counts)
        for i in range(len(counts)):
            # Get the smallest count possible
            count = counts[i]
            # If the count is within the capcity of k, remove 1 element
            if count <= k:
                res -= 1
                k -= count
            # If the count is not within the capacity of k, complete the operation
            else: 
                break
        return res