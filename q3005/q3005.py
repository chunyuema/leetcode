class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        elementFrequency = {}
        maxFrequency = 0 
        totalFrequency = 0

        for num in nums: 
            # Update the element frequency
            elementFrequency[num] = elementFrequency.get(num, 0) + 1
            
            currFrequency = elementFrequency[num]
            # If we find a higher frequency, clear the max and total
            if currFrequency > maxFrequency: 
                maxFrequency = currFrequency
                totalFrequency = currFrequency
            # Otherwise continue accruing the total
            elif currFrequency == maxFrequency:
                totalFrequency += currFrequency
        
        return totalFrequency
            