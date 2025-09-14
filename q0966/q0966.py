class Solution:
    def spellchecker(self, wordlist: List[str], queries: List[str]) -> List[str]:
        res = []

        wordSet = set(wordlist)
        lower_map = dict()
        vowel_map = dict()

        for word in wordlist:
            lower = word.lower()
            devow = self.devowel(word)

            if lower not in lower_map:
                lower_map[lower] = word
            if devow not in vowel_map:
                vowel_map[devow] = word

        for q in queries:
            if q in wordSet:
                res.append(q)
            elif q.lower() in lower_map:
                res.append(lower_map[q.lower()])
            elif self.devowel(q) in vowel_map:
                res.append(vowel_map[self.devowel(q)])
            else:
                res.append("")

        return res

    def devowel(self, word: str) -> str:
        return ''.join('*' if c.lower() in 'aeiou' else c.lower() for c in word)
