class Solution:
    def minCost(self, colors: str, neededTime: List[int]) -> int:
        res = 0
        prevColor = colors[0]
        prevCost = neededTime[0]
        for i in range(1, len(colors)):
            currColor = colors[i]
            currCost = neededTime[i]
            # If the current color is the same as previous color
            if (currColor == prevColor): 
                # Greedily remove the balloon with lower effort to minimize cost
                res += min(currCost, prevCost)
                # Previous color will remain unchanged because we removed balloon of the same color, Previous cost will change to take the higher value of prevCost and currCost
                prevCost = max(currCost, prevCost)
            # If the current color is not the same as previous color
            # Update the balloon to track a new balloon color instead
            else: 
                prevColor = currColor
                prevCost = currCost
        return res