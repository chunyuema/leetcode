class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        balance = [gas[i] - cost[i] for i in range(len(gas))]
        if sum(balance) < 0:
            return -1
        currBalance = 0
        res = 0
        for i in range(len(balance)):
            currBalance += balance[i]
            if currBalance < 0:
                currBalance = 0
                res = i + 1
        return res
