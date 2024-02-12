class Solution:
    '''
    Given that the majority element will always exist, if we just track the number of a give element
    Increment it when seeing the same number, and decrement it when seeing a different number
    The majority element will always win at the end, because its count is more than half
    '''
    def majorityElement(self, nums: List[int]) -> int:
        currElement = -1
        elementCount = 0
        for num in nums:
            if elementCount == 0:
                currElement = num
                elementCount = 1
            elif num == currElement:
                elementCount += 1
            else: 
                elementCount -= 1
        return currElement