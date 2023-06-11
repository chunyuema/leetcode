class ComparatorKey(str):
    def __lt__(x, y):
        return x + y > y + x


class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        resArray = []
        for num in nums:
            resArray.append(str(num))
        resArray = sorted(resArray, key=ComparatorKey)
        res = "".join(resArray)
        return "0" if res[0] == "0" else res
