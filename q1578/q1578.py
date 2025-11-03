class Solution:
    def minCost(self, colors: str, neededTime: List[int]) -> int:
        minCost = 0
        prevColor = colors[0]
        prevMaxCost = neededTime[0]
        for i in range(1, len(colors)):
            currColor = colors[i]
            currCost = neededTime[i]
            # If the current color is the same as previous color
            if (currColor == prevColor): 
                # Greedily remove the balloon with lower effort to minimize cost
                minCost += min(currCost, prevMaxCost)
                # Previous color will remain unchanged because we removed balloon of the same color
                # Previous cost will change to take the higher value of prevCost and currCost
                prevMaxCost = max(currCost, prevMaxCost)
            # If the current color is not the same as previous color
            # Update the balloon to track a new balloon color instead
            else: 
                prevColor = currColor
                prevMaxCost = currCost
        return minCost
