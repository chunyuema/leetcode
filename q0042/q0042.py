class Solution:
    def trap(self, height: List[int]) -> int:
        # compute the highest bar to the left of the current bar
        lefts = [0 for _ in range(len(height))]
        leftMax = height[0]
        for i in range(len(height)): 
            leftMax = max(leftMax, height[i])
            lefts[i] = leftMax
        
        # compute the highest bar to the right of the current bar
        rights = [0 for _ in range(len(height))]
        rightMax = height[-1]
        for i in range(len(height)-1, -1, -1):
            rightMax = max(rightMax, height[i])
            rights[i] = rightMax

        # the max water trapped at each bar is bounded by the min(l, r)
        # subtracted away the bar itself
        total = 0
        for i in range(len(height)-1):
            total += min(lefts[i], rights[i]) - height[i]
        return total