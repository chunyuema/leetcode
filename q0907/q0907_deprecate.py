class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        mod = 10**9 + 7
        n = len(arr)

        stack = []
        prev_smaller = [1] * n
        for i in range(n):
            while stack and arr[i] < stack[-1][0]:
                prev_smaller[i] += stack.pop()[-1]
            stack.append((arr[i], prev_smaller[i]))

        stack = []
        next_smaller = [1] * n
        for i in range(n - 1, -1, -1):
            while stack and arr[i] <= stack[-1][0]:
                next_smaller[i] += stack.pop()[-1]
            stack.append((arr[i], next_smaller[i]))

        res = 0
        for i in range(n):
            res += arr[i] * (prev_smaller[i] * next_smaller[i])
        return res % mod
