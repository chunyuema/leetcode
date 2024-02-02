class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        mod = 10**9 + 7
        n = len(arr)
        res = 0

        stack = []
        for currIndex in range(n + 1):
            while stack and (currIndex == n or arr[stack[-1]] >= arr[currIndex]):
                prevIndex = stack.pop()
                prevNum = arr[prevIndex]

                # The left boundary is the index of the last number smaller than the prevNum
                left = stack[-1] if stack else -1

                # The right boundary is the current index as the current number evicted prevNum
                right = currIndex

                # Calculate prevCount, the number of times that prevNum will be used in the sub of min(b)
                prevCount = (prevIndex - left) * (right - prevIndex)

                # Update the res
                res = (res + (prevCount * prevNum)) % mod
            stack.append(currIndex)
        
        return res
