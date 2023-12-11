class Solution(object):
    def findSpecialInteger(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        i = 0
        n = len(arr) // 4
        while i < len(arr) - n: 
            if arr[i] == arr[i+n]: return arr[i]
            i += 1
        