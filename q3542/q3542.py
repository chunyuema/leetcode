class Solution:
    def minOperations(self, nums: List[int]) -> int:
        # Maintain this stack as a monotonically increasing stack
        stack = [0]
        ops_count = 0
        for num in nums: 
            # If the incoming num is less than previous numbers on the stack
            # We will remove them. They have been previously counted
            while stack and stack[-1] > num:
                stack.pop()
            # If the incoming num is larger than previous numbers
            # Then when clearing the previous numbers, broken subarrays
            # Starting with the incoming num. Hence we need to add 1 operation
            if len(stack) == 0 or stack[-1] < num:
                ops_count += 1
                stack.append(num)
        return ops_count
