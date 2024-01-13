class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        # Track the last index of characters in the string
        indexMap = {}
        for i in range(len(s)): 
            indexMap[s[i]] = i

        res = []
        left, right = 0, 0
        for i in range(len(s)):
            # Check the last index of the current character
            lastIndex = indexMap[s[i]]
            
            # Update the closest right boundary if needed
            # If the curr char appears later, then we cannot break yet 
            right = max(right, lastIndex)

            # As soon as i == right, we know all characters before i appear before right
            # Greedily add the chunk into the res to maximize the number of arrays
            # There is no point explore further as this is the earliest possible time
            if i == right: 
                res.append(right - left + 1)
                left = right + 1
        return res