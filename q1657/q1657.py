class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        count1 = Counter(word1)
        count2 = Counter(word2)

        # The set of characters to consider must match
        keys1 = count1.keys()
        keys2 = count2.keys()
        for c in keys1:
            if c not in keys2: 
                return False
        
        # The count of all the groups collectively need to match
        # This will allow the final strings to match with operation2
        values1 = sorted(count1.values())
        values2 = sorted(count2.values())

        return values1 == values2