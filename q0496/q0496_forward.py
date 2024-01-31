class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        monoStack = []
        nextGreaterElementMap = {}
        for num in nums2:
            # all the numbers on the monotonically increasing stack
            # if they are less than the current num
            # their next greater element in nums2 is current num
            while len(monoStack) != 0 and num > monoStack[-1]:
                prevNum = monoStack.pop()
                nextGreaterElementMap[prevNum] = num
            
            # keep track of the current num
            monoStack.append(num)
        
        res = [-1] * len(nums1)
        for i in range(len(nums1)): 
            if nums1[i] in nextGreaterElementMap: 
                res[i] = nextGreaterElementMap[nums1[i]]
        return res
