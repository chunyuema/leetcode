class Solution:
    def maxBottlesDrunk(self, numBottles: int, numExchange: int) -> int:
        total = 0 
        currFull = numBottles
        currEmpty = 0

        while currFull or currEmpty >= numExchange:
            if currEmpty >= numExchange: 
                currEmpty -= numExchange
                currFull += 1
                numExchange += 1

            currEmpty += currFull
            total += currFull
            currFull = 0
        
        return total
