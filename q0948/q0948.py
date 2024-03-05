class Solution:
    def bagOfTokensScore(self, tokens: List[int], power: int) -> int:
        tokens.sort()
        low = 0
        high = len(tokens) - 1
        score = 0
        while low <= high: 
            # score whenever it is possible
            # score with the lowest token to avoid depeleting power
            if power >= tokens[low]: 
                score += 1
                power -= tokens[low]
                low += 1
            
            # only gain power and reduce score if necessary
            # gain thhe largest token possible to maximize future power
            elif score > 0 and low < high:
                score -= 1
                power += tokens[high]
                high -= 1
            
            else: 
                return score
        return score
        