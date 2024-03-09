class Solution:
    def largestValsFromLabels(self, values: List[int], labels: List[int], numWanted: int, useLimit: int) -> int:
        sortedList = sorted(zip(values, labels), reverse = True)
        labelUsage = defaultdict(int)
        
        res = 0
        numUsed = 0
        for [currValue, currLabel] in sortedList: 
            # Do not continue if we max out on the numbers used
            if numUsed == numWanted: break

            # If the usage of current label has not exceeded limit
            if (labelUsage[currLabel] < useLimit):
                res += currValue
                numUsed += 1
                labelUsage[currLabel] += 1
            # Otherwise just discard the current value
        return res