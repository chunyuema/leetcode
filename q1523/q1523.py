class Solution:
    def countOdds(self, low: int, high: int) -> int:
        right = (high + 1) // 2 # all odd numbers <= high
        left = low // 2 # all odd numbers < low
        return right - left
