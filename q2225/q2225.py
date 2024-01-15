class Solution:
    def findWinners(self, matches: List[List[int]]) -> List[List[int]]:
        records = [0] * 100001
        for winner, loser in matches: 
            # We only need to mark the winner with 1 because we do not care how many times
            if records[winner] == 0: records[winner] = 1

            # If records[loser] == 1, this loser has been winning in the previous matches
            # Flip the record to -1 to indicate that this person has lost once
            if records[loser] == 1: records[loser] = -1
            # If records[loser] is not 1, then the loser could have lost either zero / multiple times
            # Simply decrement the number of losses to track how many the person has lost
            else: records[loser] -= 1
        
        zeroLost = []
        oneLost = []
        for i in range(1, 100001): 
            if records[i] == 1: zeroLost.append(i)
            elif records[i] == -1: oneLost.append(i)
        return [zeroLost, oneLost]