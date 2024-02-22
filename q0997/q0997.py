class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        # Tracking the how many people is one person trusted by
        trustedCount = [0 for _ in range(n+1)]
        # Tracking how many people one person is willing to trust
        trustingCount = [0 for _ in range(n+1)]
        for pair in trust: 
            trustedCount[pair[1]] += 1
            trustingCount[pair[0]] += 1
        
        # Trusted by everyone else (n-1) and
        # Not trusting anyone else 0
        for i in range(1, n+1):
            if trustedCount[i] == n-1 and trustingCount[i] == 0: 
                return i
        return -1