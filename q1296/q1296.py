class Solution:
    def isPossibleDivide(self, nums: List[int], k: int) -> bool:
        numCount = dict(Counter(nums))        
        uniqueNums = sorted(list(numCount.keys()))
        for i in range(len(uniqueNums)):
            startNum = uniqueNums[i]
            # Use startNum as long as the count of it is not zero
            while numCount[startNum] != 0:
                # Check the group of k consecutive numbers to make sure it is possible
                for num in range(startNum, startNum + k):
                    if num not in numCount or numCount[num] == 0: 
                        return False
                    numCount[num] -= 1

        return True