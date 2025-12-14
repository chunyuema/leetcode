class Solution:
    def numberOfWays(self, corridor: str) -> int:
        MOD = 10**9 + 7

        # Collect the indexes of all the seats
        seats = [i for i, c in enumerate(corridor) if c == 'S']
        if len(seats) < 2 or len(seats) % 2 == 1: return 0

        res = 1
        for i in range(2, len(seats) - 1, 2):
            # This is how many plants are mixed in between, you can install a divider at any point
            # Example: SS|PPPS..., SSP|PPS..., SSPP|PS... the gap here is 3
            gap = seats[i] - seats[i - 1]
            # Toatl ways = 3 * ways afterwards
            res = (res * gap) % MOD
        return res
