class Solution:
    def maximumUnits(self, boxTypes: List[List[int]], truckSize: int) -> int:
        boxTypes.sort(key=lambda b: b[1], reverse=True)
        res = 0
        i = 0
        while i < len(boxTypes) and truckSize > 0:
            res += min(boxTypes[i][0], truckSize) * boxTypes[i][1]
            truckSize -= boxTypes[i][0]
            i += 1
        return res
