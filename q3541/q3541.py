class Solution:
    def maxFreqSum(self, s: str) -> int:
        maxFreqVowel = 0
        maxFreqConsonant = 0

        freqCounter = Counter(s)

        for c in s:
            if c in "aeiou": 
                maxFreqVowel = max(maxFreqVowel, freqCounter[c])
            else:
                maxFreqConsonant = max(maxFreqConsonant, freqCounter[c])
        
        return maxFreqVowel + maxFreqConsonant 
