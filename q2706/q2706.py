class Solution(object):
    def buyChoco(self, prices, money):
        """
        :type prices: List[int]
        :type money: int
        :rtype: int
        """
        smallest = float("inf")
        secondSmallest = float("inf")
        for price in prices: 
            if price < smallest: 
                secondSmallest = smallest
                smallest = price
            else:
                secondSmallest = min(secondSmallest, price)
        
        if money >= (smallest + secondSmallest):
            return money - (smallest + secondSmallest)
        else: 
            return money
        