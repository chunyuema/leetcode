class Solution:
    def maxArea(self, height: List[int]) -> int:
        left = 0
        right = len(height) - 1
        currMaxArea = 0
        while left < right:
            currMaxArea = max(currMaxArea, self.getArea(height, left, right))
            if (height[left] < height[right]):
                left += 1
            else: 
                right -= 1
        return currMaxArea
    
    def getArea(self, height, l, r):
        return min(height[l], height[r]) * (r - l)