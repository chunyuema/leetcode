class Solution:
    def minNumberOperations(self, target: List[int]) -> int:
        minIter = target[0]
        for i in range(1, len(target)):
            # the different between curr num and prev num
            diff = target[i] - target[i - 1]
            # if curr num > prev num: while hitting prev num, you would have partially hit curr num, 
            # => hence the left over portion is just diff
            # if curr num < prev num: while hitting prev num, you would have fully satified curr num,
            # => hence no left over portion to be added (diff will be negative)
            minIter += max(diff, 0)
        return minIter
