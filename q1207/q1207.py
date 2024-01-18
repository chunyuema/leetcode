class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        counts = Counter(arr)
        countSet = set()
        for count in counts.values():
            if count in countSet: 
                return False
            countSet.add(count)
        return True