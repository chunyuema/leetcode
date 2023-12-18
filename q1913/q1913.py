class Solution:
    def maxProductDifference(self, nums: List[int]) -> int:
        largest, secondLargest = 0, 0
        smallest, secondSmallest = float("inf"), float("inf")
        for num in nums:
            if num > largest: 
                secondLargest = largest
                largest = num
            else: 
                secondLargest = max(secondLargest, num)
            
            if num < smallest: 
                secondSmallest = smallest
                smallest = num
            else: 
                secondSmallest = min(secondSmallest, num)
        return largest * secondLargest - smallest * secondSmallest